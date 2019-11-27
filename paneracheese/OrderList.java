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
public class OrderList {
    private Queue<Order> orders = new LinkedList<>();
    
    public void placeOrder()
    {
        String order = "";
        int menu = 0;
        Scanner in = new Scanner(System.in);
        while(menu > 7 || menu < 1){
        System.out.println("Choose item to order:\n\t1 - Tea\n\t2 - Water\n\t3 - Lemonade\n\t4 - Soda\n\t5 - Bread\n\t6 - Soup\n\t7 - Sandwhich");
        menu = in.nextInt();
        }
        
        
        switch(menu)
        {
            case 1: order = "Tea"; break;
            case 2: order = "Water"; break;
            case 3: order = "Lemonade"; break;
            case 4: order = "Soda"; break;
            case 5: order = "Bread"; break;
            case 6: order = "Soup"; break;
            case 7: order = "Sandwhich";
            
        }
        
        
        
        System.out.print("\nEnter the name for the order: ");
        in.nextLine();
        String name = in.next();
        
        orders.add(new Order(name, order));
    }
    
    public void serveOrder()
    {
        System.out.println("Order ready for " + orders.poll().getName() + "!");
    }
    
    public void cancelOrder()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the name for the order to cancel: ");
        String name = in.nextLine();
        
        if(orders.removeIf((Order r) -> r.getName().equalsIgnoreCase(name)))
            System.out.println("\n" + name + "'s order has been cancelled!");
        else 
            System.out.println("\n" + name + " is not in the list of orders!");
    }
    
    public void listOrders()
    {
        if(orders.isEmpty())
            System.out.println("There are no orders");
        else
        {
            System.out.printf("%-15s%-15s%-15s\n", "Name", "Menu Item", "Time of Order");
            System.out.println("----------------------------------------");
            for(Order o : orders)
                System.out.println(o.toString());
        }
    }
}
