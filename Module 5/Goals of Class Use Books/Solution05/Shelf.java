public class Shelf
{
    private static final int SHELF_CAPACITY = 10;   
    private Book[] books;
        
    // Constructor
    public Shelf()
    {
        books = new Book[SHELF_CAPACITY];
    }
       
    // Getters (no set methods)
    public Book[] getBooks() { return books; }
    
    // Other methods

    private int findIndexOfBook(String givenTitle)
    {
        int i = 0;
        while (i < books.length)
        {
            if (books[i] != null && books[i].getTitle().equals(givenTitle))
            {
                return i;
            }
            i++;
        }
        return -1;
    }

    private int findFreeSpace()
    {
        int i = 0;
        while (i < books.length)
        {
            if (books[i] == null)
            {
                return i;
            }
            i++;
        }
        return -1;
    }

    public Book removeBook(String givenTitle)
    {
        int desiredBookIndex = findIndexOfBook(givenTitle);
        if (desiredBookIndex != -1)
        {
            Book bookToRemove = books[desiredBookIndex];
            books[desiredBookIndex] = null;
            return bookToRemove;
        }
        return null;
    }

    public boolean addBook(Book booktoAdd)
    {
        int freeSpaceIndex = findFreeSpace();
        if (freeSpaceIndex != -1)
        {
            books[freeSpaceIndex] = booktoAdd;
            return true;
        }
        return false;
    }
}