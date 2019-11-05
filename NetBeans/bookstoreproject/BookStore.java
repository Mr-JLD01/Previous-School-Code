
package bookstoreproject;


//Student Name: John Luke Denny
//LSU ID: 896463927
//Lab Section: 002
//Asssignment: Aggregation
//Submission Time: 5:15 PM

import java.util.ArrayList;
import java.util.Collections;

public class BookStore {
    //variables
    private String address;
    private String name;
    private ArrayList<Book> books = new ArrayList<>();
    
    //initiallizes address and name of the BookStore
    public BookStore(String address, String name){
        this.address = address;
        this.name = name;
    }
    
    //adds Books to the ArrayList
    public void addBook(Book bk){
        books.add(bk);
    }
    
    //Sorts the Books
    public void sortBooks(){
        Collections.sort(books);
    }
    
    //gives a formatted list of the Books
    public void listBooks(){
        System.out.printf("%-15s%-15s%-10s%-10s%n", "Title", "Author", "edition", "price");
        System.out.println("--------------------------------------------------");
        for(Book book : books){
            System.out.print(book.getInfo());
        }
        System.out.println("--------------------------------------------------");
    }
    
}
