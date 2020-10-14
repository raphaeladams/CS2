public class Reader
{
    private String name;
    private Book bookInPossession;
    
    //Constructor 
    public Reader(String newName)
    {
        name = newName;
        bookInPossession = null;
    }
    
    // Getters (no set methods)   
    public String getName() { return name; }
    public Book getBookInPossession() { return bookInPossession; }
    
    // toString   
    public String toString()
    {
        String readerString = "Reader: " + name;
        if (bookInPossession != null)
        {
            readerString += " with " + bookInPossession;
        }
        return readerString;
    }

    // Other methods
     
    // Take a book by searching for title. If there are multiple books
    // with the same given title, this method will take the first one
    public void takeBookByTitle(String desiredTitle)
    {
        if (bookInPossession == null)
        {
            bookInPossession = Bookcase.removeBook(desiredTitle);
            // remains null if no match
        }
        else
        {
            System.out.println(name + " already has " + bookInPossession);
        }
    }
    
    // Return a book 
    public void returnBook()
    {
        if (bookInPossession == null)
        {
            System.out.println(name + " has no books to return.");
        }
        else
        {
            Bookcase.addBook(bookInPossession);
            bookInPossession = null;
        }
    }
}