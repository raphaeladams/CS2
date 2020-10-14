public class Bookcase
{
    private static final int NUM_SHELVES = 5;    
    //private Shelf[] shelves;
    private static Shelf[] shelves = new Shelf[NUM_SHELVES];
    static
    {
        for (int i = 0; i < shelves.length; i++)
        {
            shelves[i] = new Shelf();
        }
    }
       
    // Constructor
    public Bookcase()
    {
        //shelves = new Shelf[NUM_SHELVES];
    }
       
    // Getters (no set methods)
    public Shelf[] getShelves() { return shelves; }
    
    // Other methods
    
    // Add a book
    public static boolean addBook(Book booktoAdd)
    {
        int i = 0;
        while (i < shelves.length)
        {
            if (shelves[i].addBook(booktoAdd))
            {
                return true;
            }
            i++;
        }
        System.out.println("No room on this bookcase to add " + booktoAdd);
        return false;
    }

    // Remove a book when we know the exact Book object to remove
    public static Book removeBook(Book givenBook)
    {
        int i = 0;
        while (i < shelves.length)
        {
            Book desiredBook = shelves[i].removeBook(givenBook);
            if (desiredBook != null)
            {
                return desiredBook;
            }
            i++;
        }
        System.out.println("Sorry! No matches found.");
        return null;
    }
    
    // Remove a book when we know its ISBN
    public static Book removeBookByISBN(int givenISBN)
    {
        int i = 0;
        while (i < shelves.length)
        {
            Book desiredBook = shelves[i].removeBookByISBN(givenISBN);
            if (desiredBook != null)
            {
                return desiredBook;
            }
            i++;
        }
        System.out.println("Sorry! No matches found.");
        return null;
    }

    // Remove a book when we know its title. If there are multiple books
    // with the same given title, this method will remove the first one
    public static Book removeBookByTitle(String givenTitle)
    {
        int i = 0;
        while (i < shelves.length)
        {
            Book desiredBook = shelves[i].removeBookByTitle(givenTitle);
            if (desiredBook != null)
            {
                return desiredBook;
            }
            i++;
        }
        System.out.println("Sorry! No matches found.");
        return null;
    }

    // Remove a book when we know its author. If there are multiple books
    // with the same given author, this method will remove the first one
    public static Book removeBookByAuthor(String givenAuthor)
    {
        int i = 0;
        while (i < shelves.length)
        {
            Book desiredBook = shelves[i].removeBookByAuthor(givenAuthor);
            if (desiredBook != null)
            {
                return desiredBook;
            }
            i++;
        }
        System.out.println("Sorry! No matches found.");
        return null;
    }
}