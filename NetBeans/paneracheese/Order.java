//Student Name: John Luke Denny
//LSU ID: 896463927
//Lab Section: 002
//Assignment: Switch Statements and Queues
//Submission Time: 5:22 PM

package paneracheese;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author jdenny3
 */
public class Order {
    private LocalDateTime orderTime;
    private String name;
    private String item;
    
    public Order(String n, String i)
    {
        this.name = n;
        this.item = i;
        this.orderTime = java.time.LocalDateTime.now();
    }
    
    public String getName()
    {
        return this.name;
    }
    
    @Override
    public String toString()
    {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("HH:mm:ss");
        return String.format("%-15s%-15s%-15s", name, item, orderTime.format(dft));
    }
}
