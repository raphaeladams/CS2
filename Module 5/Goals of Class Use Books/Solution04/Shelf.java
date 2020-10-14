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

    public int findIndexOfBook(String givenTitle)
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

    public int findFreeSpace()
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

    public Book removeBook(int index)
    {
        Book bookToRemove = books[index];
        books[index] = null;
        return bookToRemove;
    }

    public void addBook(int index, Book booktoAdd)
    {
        books[index] = booktoAdd;
    }
}