public class Reader
{
    private String name;
    private Book bookInPossession;
    

    public Reader(String newName)
    {
        name = newName;
        bookInPossession = null;
    }
    
    
    ////
    // Getters (no set methods)   
    public String getName() { return name; }
    public Book getBookInPossession() { return bookInPossession; }
    
    
    
    ////
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


    ////
    // Other methods
    //TODO shouldn't need to specify bookcase when taking/returning books
     
    // Take a book when we know the exact Book object we want to take
    public void takeBook(Book desiredBook, Bookcase thisBookcase)
    {
        if (bookInPossession == null)
        {
            bookInPossession = thisBookcase.removeBook(desiredBook);
            // remains null if no match
        }
        else if (bookInPossession == desiredBook)
        {
            System.out.println(name + " already has this book!");
        }
        else
        {
            System.out.println(name + " already has " + bookInPossession + 
                ". You must return a book before taking another!");
        }
    }
    
    // Take a book by searching for ISBN
    public void takeBook(int desiredISBN, Bookcase thisBookcase)
    {
        if (bookInPossession == null)
        {
            bookInPossession = thisBookcase.removeBook(desiredISBN);
            // remains null if no match
        }
        else if (bookInPossession.getISBN() == desiredISBN)
        {
            // If the ISBN matches, it's the exact same book
            System.out.println(name + " already has this book!");
        }
        else
        {
            System.out.println(name + " already has " + bookInPossession + 
                ". You must return a book before taking another!");
        }
    }

    // Take a book by searching for title or author. If there are multiple books
    // with the same given title/author, this method will take the first one
    public void takeBook(String desiredTitleOrAuthor, Bookcase thisBookcase)
    {
        if (bookInPossession == null)
        {
            bookInPossession = thisBookcase.removeBook(desiredTitleOrAuthor);
            // remains null if no match
        }
        else
        {
            System.out.println(name + " already has " + bookInPossession + 
                ". You must return a book before taking another!");
        }
    }
    
    
    // Return a book. We will assume that these readers are good people and 
    // they put back the books where they found them :) 
    public void returnBook(Bookcase thisBookcase)
    {
        if (bookInPossession == null)
        {
            System.out.println(name + " has no books to return.");
        }
        else
        {
            thisBookcase.addBook(bookInPossession);
            bookInPossession = null;
        }
    }
}