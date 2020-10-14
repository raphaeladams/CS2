public class Book
{
    // Use this to make a new 10-digit ISBN for each
    // new book we create. Assume they won't go above 9999999999
    private static int CURR_ISBN = 1000000000;
    
    private String title;
    private String author;
    private int isbn; // we will ignore dashes and other formatting

    //TODO shouldn't need to track anything related to shelf/bookcases here
    //private int shelfNumber;
    //private int shelfPosition;
    
    public Book(String newTitle, String newAuthor)
    {
        title = newTitle;
        author = newAuthor;
        isbn = CURR_ISBN++;

        //shelfNumber = -1;
        //shelfPosition = -1; // -1 indicates the book isn't on a bookcase yet
    }
    
    ////
    // Getters (no set methods)
    
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getISBN() { return isbn; }

    //public int getShelfNumber() { return shelfNumber; } 
    //public int getShelfPosition() { return shelfPosition; }
    
    
    ////
    // toString
    
    public String toString()
    {
        return title + " by " + author + ": " + isbn;
    }


    ////
    // Other methods  
    
    /*public void assignShelfSpace(int designatedShelfNum, int designatedShelfPos)
    {
        shelfNumber = designatedShelfNum;
        shelfPosition = designatedShelfPos;
    }*/
}