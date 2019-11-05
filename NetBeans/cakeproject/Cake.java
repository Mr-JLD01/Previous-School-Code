
//Student Name: John Luke Denny
//LSU ID: 896463927
//Lab Section: 002
//Assignment : Inheritance
//Submission Time: 5:00

package cakeproject;

/**
 *
 * @author jdenny3
 */
public class Cake {
    
    private String flavor;
    private int tiers;
    private double price;
    
    //initializes variables
    public Cake(String Flavor, int Tiers, double Price){
        flavor = Flavor;
        tiers = Tiers;
        price = Price;
    }
    
    //ooutputs and invoice with flavor, tier, price, and date
    public void printInvoice(){
        System.out.println("A " + tiers + " tier " + flavor + " cake. The price is $" + price + ". Issued on: " + java.time.LocalDate.now());
    } 
    
    //outputs a message from the cake company
    public void printCard(){
        System.out.println("Thank you for choosing us!");
    }
}
