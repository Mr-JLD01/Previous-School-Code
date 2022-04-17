import java.util.ArrayList;
public class Library {
    String address;
    ArrayList<Book> books = new ArrayList<Book>();
    
    public static void main(String[] args) {
    // Create two libraries
    Library firstLibrary = new Library("10 Main St.");
    Library secondLibrary = new Library("228 Liberty St.");
    // Add four books to the first library
    firstLibrary.addBook(new Book("The Da Vinci Code"));
    firstLibrary.addBook(new Book("Le Petit Prince"));
    firstLibrary.addBook(new Book("A Tale of Two Cities"));
    firstLibrary.addBook(new Book("The Lord of the Rings"));
    // Print opening hours and the addresses
    System.out.println("Library hours:");
    printOpeningHours();
    System.out.println();
    System.out.println("Library addresses:");
    firstLibrary.printAddress();
    secondLibrary.printAddress();
    System.out.println();
    // Try to borrow The Lords of the Rings from both libraries
    System.out.println("Borrowing The Lord of the Rings:");
    firstLibrary.borrowBook("The Lord of the Rings");
    firstLibrary.borrowBook("The Lord of the Rings");
    secondLibrary.borrowBook("The Lord of the Rings");
    System.out.println();
    // Print the titles of all available books from both libraries
    System.out.println("Books available in the first library:");
    firstLibrary.printAvailableBooks();
    System.out.println();
    System.out.println("Books available in the second library:");
    secondLibrary.printAvailableBooks();
    System.out.println();
    // Return The Lords of the Rings to the first library
    System.out.println("Returning The Lord of the Rings:");
    firstLibrary.returnBook("The Lord of the Rings");
    System.out.println();
    // Print the titles of available from the first library
    System.out.println("Books available in the first library:");
    firstLibrary.printAvailableBooks();
   }
   
   public static void printOpeningHours(){
       System.out.println("Libraries are open daily from 9am to 5pm.");
   }
    
   public Library(String addr){
       address = addr;
   }
   
   public void addBook(Book book){
       books.add(book);
   }
   
   public void printAddress(){
       System.out.println(address);
   }
   
   //changes the borrowed variable of the book to true, if it wasn't already
   public void borrowBook(String title){
       for(int i = 0; i < books.size(); i++){
           if(title.equals(books.get(i).getTitle())){
               if(books.get(i).isBorrowed()){
                   System.out.println("Sorry, this book is already borrowed.");
                   return;
               }
               else{
                   System.out.println("You successfully borrowed " + title);
                   books.get(i).borrowed();
                   return;  
                }
            }
       }
       System.out.println("Sorry, this book is not in our catalog.");
   }
   
   //changes the borrowed variable of the book to false, if it wasn't already
   public void returnBook(String title){
       for(int i = 0; i < books.size(); i++){
           if(title.equals(books.get(i).getTitle())){
               if(books.get(i).isBorrowed()){
                   System.out.println("You successfully returned " + title);
                   books.get(i).returned();
                   return;
               }
               else{
                   System.out.println("Sorry, we already have a copy of " + title);
                   return;  
                }
            }
       }
       System.out.println("Sorry, this book is not in our catalog.");
   }
   
   //sees if book is available and prints the title
   public void printAvailableBooks(){
       int counter = 0;
       for(int i = 0; i < books.size(); i++){
           if(!books.get(i).isBorrowed()){
               counter++;
               System.out.println(books.get(i).getTitle());
            }
        }
       if(counter == 0)
            System.out.println("No book in catalog");
   }
}