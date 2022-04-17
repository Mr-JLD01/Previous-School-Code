
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
public class WeddingCake extends Cake{
    
    private String bridesFirstName;
    private String groomsFirstName;
    
    //initializes variables of Cake and WeddingCake
    public WeddingCake(String Flavor, int Tiers, double Price, String brideName, String groomName){
        super(Flavor, Tiers, Price);
        bridesFirstName = brideName;
        groomsFirstName = groomName;
    }
    
    //overrides Cake printinfo and adds more
    @Override
    public void printCard(){
        System.out.println("Happy Wedding to " + bridesFirstName + " and " + groomsFirstName + "!");
        super.printCard();
    }
    
}
