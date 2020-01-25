
/**
 * Creates a binary tree from either manually inserted nodes or an array
 */

import java.util.*;

public class BinaryTree
{
    // instance variables - replace the example below with your own
    public Node root;

    /**
     * Constructor for objects of class BinaryTree
     */
    public BinaryTree()
    {
        // initialise instance variables
        root = null;
    }
    
    public BinaryTree(int[] nodes)
    {
        createTree(nodes);
    }
    //inserts values recursively with lesser values moving left and greater values moving
    //right
    public void insert( Node node, int val)
    {
        
        if(val < node.value)
        {
            if(node.left != null)
                insert(node.left, val);
            else{
                node.left = new Node(val);
                System.out.println(val + " left of " + node.value);
            }
        }  
        
        if(val > node.value)
        {
            if(node.right != null)
                insert(node.right, val);
            else{
                node.right = new Node(val);
                System.out.println(val + " right of " + node.value);
            }
        }  
    }
    // creates a tree given an array and creates a binary tree using a root
    public void createTree(int[] nodes)
    {
        root = new Node(nodes[0]);
        
        for(int i = 1; i < nodes.length; i++)
        {
            insert(root, nodes[i]);
        }
    }
    // outputs the elements of the tree in Parent, Left, Right order
    public void traversePreorder(Node node)
    {
        if(node != null)
        {
            System.out.print(" " + node.value);
            traversePreorder(node.left);
            traversePreorder(node.right);
        }
    }
    // outputs the elements of the tree in Left, Parent, Right order
    public void traverseInorder(Node node)
    {
        if(node != null)
        {
            traverseInorder(node.left);
            System.out.print(" " + node.value);
            traverseInorder(node.right);
        }
    }
    // outputs the elements of the tree in Left, Right, Parent order
    public void traversePostorder(Node node)
    {
        if(node != null)
        {
            traversePostorder(node.left);
            traversePostorder(node.right);
            System.out.print(" " + node.value);
        }
    }
    //outputs the elements of the tree in order of the level
    //the method has been converted to return a string for a latter method to remove a value
    //this change creates a duplication in the output if both traverseLevel and remove
    //are called
    public String traverseLevel(Node node)
    {
       int h = height(node);
       String tree = "";
       for(int lvl = 1; lvl <= h; lvl++)
       {
           System.out.print("\nlvl " + lvl + ":");
           tree += printLvl(node, lvl, "");
       }
       System.out.println("\n");
       return tree;
    }
    //finds the height of a tree
    public int height(Node node) 
    { 
        if (node == null) 
           return 0; 
        else
        { 
            int lefth = height(node.left); 
            int righth = height(node.right); 
            
            if (lefth > righth) 
                return(lefth+1);
                
            else 
                return(righth+1);  
        } 
    } 
    //Contributes to the duplication issue in traverseLevel but is used to get a string of
    // all the elements in level order to be scanned and parsed
    public String printLvl (Node node ,int lvl, String tree) 
    { 
        if (node == null) 
            return ""; 
        if (lvl == 1){ 
            System.out.print(" " + node.value);
            tree += " " + node.value; 
            return tree;
        }
        else if (lvl > 1) 
        { 
            tree += printLvl(node.left, lvl - 1, ""); 
            tree += printLvl(node.right, lvl - 1, "");
            return tree;
        }
        return "";
    }
}
