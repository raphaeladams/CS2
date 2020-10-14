public class Book
{
    // Use this to make a new 10-digit ISBN for each
    // new book we create. Assume they won't go above 9999999999
    private static int CURR_ISBN = 1000000000;   
    private String title;
    private String author;
    private int isbn; // we will ignore dashes and other formatting
    
    // Constructor
    public Book(String newTitle, String newAuthor)
    {
        title = newTitle;
        author = newAuthor;
        isbn = CURR_ISBN++;
    }
    
    // Getters (no set methods)   
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getISBN() { return isbn; }    
    
    // toString    
    public String toString()
    {
        return title + " by " + author + ": " + isbn;
    }
}