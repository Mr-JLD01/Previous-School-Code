
/**
 * This is a base object class to create nodes to be used in heaps and binary trees
 * John Luke Denny
 * 1/25/2020
 */
public class Node
{
    // instance variables
    public int value;
    public Node left;
    public Node right;

    /**
     * Constructor for objects of class Node
     */
    public Node(int val)
    {
        // initialise instance variables
        value = val;
        left = null;
        right = null;
    }
    
}
