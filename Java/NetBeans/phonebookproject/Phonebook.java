//Student Name: John Luke Denny
//LSU ID: 896463927
//Lab Section: 002
//Asssignment: Object Oriented Design
//Submission Time: 5:20 PM
package phonebookproject;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author jdenny3
 */
public class Phonebook {
    private ArrayList<Person> people = new ArrayList<>();
    private ArrayList<Business> companies = new ArrayList<>();
    
    //default constructor to create an empty phonebook
    public Phonebook()
    {
    }
    
    //adds a person to the phonebook
    public void addPerson(String name, long phone, String relation)
    {
        people.add(new Person(name, phone, relation));
    }
    
    //adds a business to the phonebook
    public void addBusiness(String company, long phone, int zip)
    {
        companies.add(new Business(company, phone, zip));
    }
    
    //prints out the information of the phonebook
    public void printContacts()
    {
        Collections.sort(people);
        Collections.sort(companies);
        System.out.printf("%-20s%-15s%-15s%n", "Person Name", "Phone", "Relationship");
        System.out.println("--------------------------------------------------");
        for(Person p : people)
            System.out.println(p.getInfo());
        System.out.println("--------------------------------------------------");
        System.out.printf("%-20s%-15s%-15s%n", "Business Name", "Phone", "Zip");
        System.out.println("--------------------------------------------------");
        for(Business c : companies)
            System.out.println(c.getInfo());
         System.out.println("--------------------------------------------------");
    }
}
