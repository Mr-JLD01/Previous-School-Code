
/**
 * Creates a special type of binary tree that complete and balanced
 * John Luke Denny
 * 1/27/2020
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
    //inserting the other values in based on the highest power of the position in binary
    @Override
    public void createTree(int[] nodes)
    {
        root = new Node(nodes[0]);
        
        for(int i = 1; i < nodes.length; i++)
        {
            int pow = positionBinaryPow(i + 1);
            //since all positions on a lvl contain the highest power, it must start one
            //power less and as such adjust the position input accordingly
            insert(root, i + 1 - (int)Math.pow(2,pow), pow - 1, nodes[i]);
        }
        
        heapSort(root);
    }
    //using the binary position array, moving left in the array from before the final position
    //becasue in all the arrays of the position will be of value 1, a 0 means to look left,
    // and a 1 means to look right
    //The sys.out.p statements are used to trace the initial insert of the node values
    public void insert(Node node, int pos, int pow, int val)
    {
        if(pos < Math.pow(2, pow))
        {
            if(node.left != null)
            {
                insert(node.left, pos, --pow, val);
            }
            
            else
            {
                node.left = new Node(val);
                System.out.println(val + " left of " + node.value);
            }
        }
        else if(pos >= Math.pow(2, pow))
        {
            if(node.right != null)
            {
                insert(node.right, pos - (int)Math.pow(2,pow), --pow, val);
            }
            
            else 
            {
                node.right = new Node(val);
                System.out.println(val + " right of " + node.value);
            }
        }
    }
    //this finds the highest power of the position in binary
    public int positionBinaryPow(int pos)
    {
        int pow = 0;
        //this is used to find the highest power of 2 that includes all numbers of a level
        //it is because it seeks to have the same size array for all values on a level
        //that there is an ='s in the check for the exponents of 2
        while(pos >= Math.pow(2, pow))
        {
            pow++;
        }
        
        // System.out.println(Arrays.toString(posBin));
        return pow - 1;
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
