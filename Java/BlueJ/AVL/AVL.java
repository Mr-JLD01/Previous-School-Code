import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.*;

    /**
       *
        * @author Nicholas Levergne, John Luke Denny
          */
public class AVL{
    public static void main(String[] args) throws FileNotFoundException {
        
        
        File inFile = new File("inputFile.txt");//new File(args[0]);
        Scanner in = new Scanner(inFile);
        int numInstruct = in.nextInt();

        String command = in.next();
        int num1 = in.nextInt();
        int num2 = in.nextInt();

        Node root = new Node(num1, num2);
        Tree tree = new Tree(root);
    
        for (int i = 2; i <= numInstruct; i++) {
            command = in.next();
            if(command.equals("IN")) {
                num1 = in.nextInt();
                num2 = in.nextInt();
                tree.insert(root, new Node(num1, num2)); 
            }
            else if(command.equals("RM")){
                int min = 9999999;
                num1 = in.nextInt();
                num2 = in.nextInt(); 
                
                System.out.println("" + tree.RangeMinData((tree.root), num1, num2, min));
            }
        }
    }
}
    class Node
    {
        int key, height, data, mindata;
        Node left, right, parent;
        Node(int d, int Data)
        {
            key = d;
            height = 1;
            data = Data;
        }
    }
    class Tree
    {
        Node root;
        public Tree(Node rt){
            root = rt;
        }
    void recalcHeight(Node x) 
    {
        if (x == null){}
        else if (x.left == null && x.right == null) 
        {
            x.height = 1;
        }
        else 
        {
            recalcHeight(x.left);
            recalcHeight(x.right);
            if(x.left == null)
                x.height = x.right.height;
            else if(x.right == null)
                x.height = x.left.height;
            else
                x.height = (x.left.height < x.right.height) ? x.right.height : x.left.height;
            x.height += 1;
            if(x.left != null && x.right != null){
                if (x.left.height - x.right.height > 1)
                    rotateRight(x);
                else if (x.left.height - x.right.height < -1)
                    rotateLeft(x);
            }
        }
    }
        int max(int a, int b)
        {
            return (a > b) ? a:b;
        }
        Node rotateRight(Node y) 
        { 
            Node x = y.left;
            Node z = x.right;
            
            x.right = y;
            y.left = z;
            
            recalcHeight(x);
            recalcHeight(y);
            
            return x; 
        } 
        Node rotateLeft(Node x) 
        { 
            Node y = x.right;
            Node z = y.left;
            
            y.left = x;
            x.right = z;
            
            recalcHeight(x);
            recalcHeight(y);
            
            return y; 
        } 
        int getBalance(Node x)
        {
            if(x == null)
                return 0;
            else if((x.right != null) && (x.left != null))
                return x.left.height - x.right.height; 
            else if (x.right != null)
                return x.right.height;
            else if(x.left != null)
                return x.left.height;
            else
                return 1;
        }
        static void insert(Node x, Node z) 
        {
            if (x.key > z.key) {
                if (x.left != null) {
                    insert(x.left, z);
                }
                else 
                {
                    x.left = z;
                }
            }
            else if (x.key < z.key) 
            {
                if (x.right != null) 
                {
                    insert(x.right, z);
                }
                else 
                {
                    x.right = z;
                }
            }
        }
        int RangeMinData(Node x, int k1, int k2, int minimum) 
        {      
        if (x == null)
            return 9999999;
        else if(!(x.key <= k2 && x.key >= k1)) 
        {
            if(x.left != null && x.key > k2){
                
                minimum = RangeMinData(x.left, k1, k2, minimum);
            }
            else if(x.right != null && x.key < k1){
                
                minimum = RangeMinData(x.right, k1, k2, minimum);
            }
        }
        else 
        {
            if(x.left == null && x.right == null)
                minimum = x.data;
            else{
            int lmin = RangeMinData(x.left, k1, k2, minimum);
            int rmin = RangeMinData(x.right, k1, k2, minimum);
 
            minimum = Math.min(x.data, Math.min(lmin, rmin));
            }   
        }
        return minimum;
    }
        void inorder(Node x) 
        { 
            if(x == null) 
                return;
            inorder(x.left); 
            System.out.print("(" + x.key + "," + x.data +")"); 
            inorder(x.right); 
        } 
    }
