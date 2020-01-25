import java.util.*;
/**
 * runs main method to test heap and binary tree
 * John Luke Denny
 */
public class BinaryHeapTreeRunner
{
    
  public static void main(String args[])
  {

    System.out.println("Binary trees\nTree 1:\n");
    BinaryTree tree = new BinaryTree();
    int[] vals = {5, 4, 6, 7, 77, -2, -9, 3};
    tree.createTree(vals);
    tree.traverseInorder(tree.root);
    
    System.out.println("\nTree 2:\n");
    
    int[] values = {44, 53, -10, 2, 22, 99, 100, 24};
    BinaryTree bush = new BinaryTree(values);
    bush.traverseInorder(bush.root);
    System.out.println("");
    bush.traverseLevel(bush.root);
    
    System.out.println("\nHeap tree\n");
    
    HeapTree heap = new HeapTree(values);
    
    heap.traverseLevel(heap.root);
    System.out.println("");
    heap.remove(heap.root, 2);
    heap.traverseLevel(heap.root);
    heap.traversePreorder(heap.root);
    
  }
}
