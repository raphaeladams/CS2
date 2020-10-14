public class Shelf
{
    private static final int SHELF_CAPACITY = 10;   
    private Book[] books;
    //private static Book[] books = new Book[SHELF_CAPACITY];
        
    // Constructor
    public Shelf()
    {
        books = new Book[SHELF_CAPACITY];
    }
       
    // Getters (no set methods)
    public Book[] getBooks() { return books; }
    
    // Other methods
    
    // Add a book -> put it in the next free space in the array
    public boolean addBook(Book booktoAdd)
    {
        int i = 0;
        while (i < books.length)
        {
            if (books[i] == null)
            {
                books[i] = booktoAdd;
                return true;
            }
            i++;
        }
        return false;
    }

    // Remove a book when we know the exact Book object to remove
    public Book removeBook(Book givenBook)
    {
        int i = 0;
        while (i < books.length)
        {
            if (books[i] == givenBook)
            {
                Book desiredBook = books[i];
                books[i] = null;
                return desiredBook;
            }
            i++;
        }
        return null;
    }

    // Remove a book when we know its ISBN
    public Book removeBookByISBN(int givenISBN)
    {
        int i = 0;
        while (i < books.length)
        {
            if (books[i] != null && books[i].getISBN() == givenISBN)
            {
                Book desiredBook = books[i];
                books[i] = null;
                return desiredBook;
            }
            i++;
        }
        return null;
    }

    // Remove a book when we know its title. If there are multiple books
    // with the same given title, this method will remove the first one
    public Book removeBookByTitle(String givenTitle)
    {
        int i = 0;
        while (i < books.length)
        {
            if (books[i] != null && books[i].getTitle().equals(givenTitle))
            {
                Book desiredBook = books[i];
                books[i] = null;
                return desiredBook;
            }
            i++;
        }
        return null;
    }

    // Remove a book when we know its author. If there are multiple books
    // with the same given author, this method will remove the first one
    public Book removeBookByAuthor(String givenAuthor)
    {
        int i = 0;
        while (i < books.length)
        {
            if (books[i] != null && books[i].getAuthor().equals(givenAuthor))
            {
                Book desiredBook = books[i];
                books[i] = null;
                return desiredBook;
            }
            i++;
        }
        return null;
    }
}