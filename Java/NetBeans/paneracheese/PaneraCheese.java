//Student Name: John Luke Denny
//LSU ID: 896463927
//Lab Section: 002
//Assignment: Switch Statements and Queues
//Submission Time: 5:22 PM

package paneracheese;


import java.util.*;

/**
 *
 * @author jdenny3
 */
public class PaneraCheese {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OrderList orders = new OrderList();
        Scanner in = new Scanner(System.in);
        int choice = 0;
        while(choice != 9)
        {
            System.out.println("Select one of the following:\n\t1 - Place and order\n\t2 - Serve next order\n\t3 - List all orders\n\t4 - Cancel and order\n\t9 - End program");
            choice = in.nextInt();
            
            switch(choice)
            {
                case 1: orders.placeOrder();break;
                case 2: orders.serveOrder();break;
                case 3: orders.listOrders();break;
                case 4: orders.cancelOrder();break;
                case 9: break;
                default: System.out.println("Invalid Choice");
            }
        }
    }
    
}
