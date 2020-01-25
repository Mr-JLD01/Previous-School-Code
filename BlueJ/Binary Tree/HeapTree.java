
/**
 * Creates a special type of binary tree that complete and balanced
 * John Luke Denny
 * 1/25/2020
 */
 
    import java.util.*;

public class HeapTree extends BinaryTree
{
    
    /**
     * Constructor for objects of class HeapTree
     */
    public HeapTree()
    {
        // initialise instance variables
        super();
    }
    
    public HeapTree(int[] nodes)
    {
        createTree(nodes);
    }
    //createTree method takes an array and creates a heap tree using the a root and
    //inserting the other values in based on an array of the position in binary
    @Override
    public void createTree(int[] nodes)
    {
        root = new Node(nodes[0]);
        
        for(int i = 1; i < nodes.length; i++)
        {
            int[] location = positionBinary(i + 1);
            insert(root, location.length - 2, location, nodes[i]);
        }
        
        heapSort(root);
    }
    //using the binary position array, moving left in the array from before the final position
    //becasue in all the arrays of the position will be of value 1, a 0 means to look left,
    // and a 1 means to look right
    //The sys.out.p statements are used to trace the initial insert of the node values
    public void insert(Node node, int lvl, int[] loc, int val)
    {
        if(loc[lvl] == 0)
        {
            if(node.left != null)
            {
                insert(node.left, --lvl, loc, val);
            }
            
            else
            {
                node.left = new Node(val);
                System.out.println(val + " left of " + node.value);
            }
        }
        else if(loc[lvl] == 1)
        {
            if(node.right != null)
            {
                insert(node.right, --lvl, loc, val);
            }
            
            else 
            {
                node.right = new Node(val);
                System.out.println(val + " right of " + node.value);
            }
        }
    }
    //this finds the array of the position in binary
    public int[] positionBinary(int pos)
    {
        int pow = 0;
        //this is used to find the highest power of 2 that includes all numbers of a level
        //it is because it seeks to have the same size array for all values on a level
        //that there is an ='s in the check for the exponents of 2
        while(pos >= Math.pow(2, pow))
        {
            pow++;
        }
        //though numbers would be checked for a power of 2 higher than what could be
        //represented, this declaration gets rid of the trailing 0 that could have been in
        //every array if the size was increased by 1. The trailing 1, however, cannot be
        //removed due to how finding a number's binary representation works
        int[] posBin = new int[pow];
        
        for(int i = posBin.length - 1; i > -1; i--)
        {
            if(pos >= Math.pow(2, i))
            {
                posBin[i] = 1;
                pos -= Math.pow(2, i);
            }
        }
        // System.out.println(Arrays.toString(posBin));
        return posBin;
    }
    //takes the height of a heap to sort the nodes to make it fit the heap definition
    //to my surprise, I found out that it doesnt matter if the heap nodes are swapped
    //during the process or afterwards. Both result in the same heap
    //Also, the maximum number of runs a heap would have to take to be sorted properly
    //is equal to the height of the heap
    public void heapSort(Node node)
    {
        int h = height(node);

        for(int i = 1; i < h; i++)
        {
            sort(node);
        }
    }
    //this method sorts the nodes by bringing up the smaller values to the top
    public void sort (Node node) 
    {    
        if(node.left != null)
        {
            if(node.left.value < node.value){
            int sto = node.value;
            node.value = node.left.value;
            node.left.value = sto;
            }
            sort(node.left);
        }
        if(node.right != null)
        {
            if(node.right.value < node.value){
            int sto = node.value;
            node.value = node.right.value;
            node.right.value = sto;
            }
            sort(node.right);
        }
    } 
    //removes an element from a heaptree
    public void remove(Node root, int val)
    {
        Scanner level = new Scanner(traverseLevel(root));
        LinkedList<Integer> lvlArr = new LinkedList<>();
        while(level.hasNextInt())
        {
            lvlArr.add(level.nextInt());
        }
        lvlArr.set(lvlArr.indexOf(new Integer(val)), lvlArr.getLast());
        lvlArr.removeLast();
        int[] newTree = new int[lvlArr.size()];
        int pos = 0;
        while(lvlArr.size() > 0)
        {
            newTree[pos++] = lvlArr.remove().intValue();
        }
        //System.out.println(Arrays.toString(newTree));
        createTree(newTree);
    }
}
