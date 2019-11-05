
//Student Name: John Luke Denny
//LSU ID: 896463927
//Lab Section: 002
//Asssignment: Aggregation
//Submission Time: 5:15 PM

package bookstoreproject;

public class Book implements Comparable<Book>{
    
    //variables
    private String title;
    private String author;
    private int edition;
    private double price;
    
    //constructor that initializes the title, author, edition, and name
    public Book(String title, String author, int edition, double price){
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.price = price;
    }
    
    //returns a formatted string of the variables
    public String getInfo(){
        return String.format("%-15s%-15s%-10d%-10f%n", title.substring(0,10), author.substring(0,10), edition, price);
    }

    //compares Books by their title
    @Override
    public int compareTo(Book other){
        return title.compareTo(other.title);
    }
    
    
}
