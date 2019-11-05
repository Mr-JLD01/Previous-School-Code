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
public class PhonebookProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Phonebook myPhoneBook = new Phonebook();
        
        myPhoneBook.addBusiness("WalMart", 22566647, 70809);
        myPhoneBook.addBusiness("Chick-fil-a", 22533448, 70808);
        myPhoneBook.addBusiness("Alpha Mechanic", 22566789, 70813);
        
        myPhoneBook.addPerson("Luke Skywalker", 22500111, "Brother");
        myPhoneBook.addPerson("Darth Vader", 22500122, "Father");
        myPhoneBook.addPerson("Princess Lia", 22500133, "Sister");
        
        myPhoneBook.printContacts();
    }
    
}
