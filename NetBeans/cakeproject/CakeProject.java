
//Student Name: John Luke Denny
//LSU ID: 896463927
//Lab Section: 002
//Assignment : Inheritance
//Submission Time: 5:00

package cakeproject;

public class CakeProject {

    // compiles multiple cake objects and calls for info and cards
    public static void main(String[] args) {
        WeddingCake wedCk = new WeddingCake("chocolate", 3, 355.0, "Sarah", "John");
        wedCk.printInvoice();
        wedCk.printCard();
        
        System.out.println();
        
        BirthdayCake bdCk = new BirthdayCake("vanilla", 1, 20.0, "Alan", 15);
        bdCk.printInvoice();
        bdCk.printCard();
    }
    
}
