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
public class Business extends Contact{
    private int zip;
    
    //default constructor for a business
    public Business()
    {
        super();
    }
    
    //constuctor for businesses
    public Business(String Name, long Phone, int Zip)
    {
        super(Name, Phone);
        zip = Zip;
    }
    
    //prints the info of businesses from contacts and adds zip
    @Override
    public String getInfo()
    {
        return super.getInfo() + String.format("%-15d", zip);
    }
    
}
