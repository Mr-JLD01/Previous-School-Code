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
public class Contact implements Comparable<Contact>{
    private String name;
    private long phone;
    
    //default constructor
    public Contact()
    {
        name = "John Doe";
        phone = 55555555;
    }
    
    //constructor with variables name and phone 
    public Contact(String Name, Long Phone)
    {
        name = Name;
        phone = Phone;
    }
    
    //returns a string of the name and phone
    public String getInfo()
    {
        return String.format("%-20s%-15d", name, phone);
            
    }
    
    //compares contacts by name
    @Override
    public int compareTo(Contact other)
    {
        return name.compareTo(other.name);
    }
}
