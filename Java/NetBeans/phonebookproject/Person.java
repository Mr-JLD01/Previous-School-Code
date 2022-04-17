//Student Name: John Luke Denny
//LSU ID: 896463927
//Lab Section: 002
//Asssignment: Object Oriented Design
//Submission Time: 5:20 PM
package phonebookproject;

/**
 *
 * @author jdenny3
 */
public class Person extends Contact{
    private String relationship;
    
     //default constructor for a person
    public Person()
    {
        super();
        relationship = "Stranger";
    }
    
    //constuctor for person
    public Person(String Name, long Phone, String relate)
    {
        super(Name, Phone);
        relationship = relate;
    }
    
    //returns the info of the person from contact and adds relationship
    @Override
    public String getInfo()
    {
        return super.getInfo() + String.format("%-15s", relationship);
    }
}
