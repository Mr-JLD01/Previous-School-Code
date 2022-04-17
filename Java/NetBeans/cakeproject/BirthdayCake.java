
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
public class BirthdayCake extends Cake{
    
    private String firstName;
    private int age;
    
    //initializes variables of Cake and BirthdayCake
    public BirthdayCake(String Flavor, int Tiers, double Price, String name, int Age){
        super(Flavor, Tiers, Price);
        firstName = name;
        age = Age;
    }
    
    //overrides Cake printinfo and adds more
    @Override
    public void printCard(){
        System.out.println("Happy Birthday to " + firstName + "! You just turned " + age + " :)");
        super.printCard();
    }
    
}
