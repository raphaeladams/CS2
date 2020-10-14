public class Bookcase
{
    private static final int NUM_SHELVES = 5;
    //private static int CURR_SHELF_NUM = 0;
    
    //private Shelf[] shelves;
    //private static Shelf[] shelves = new Shelf[NUM_SHELVES];
    private static Shelf[] shelves = {
        new Shelf(),
        new Shelf(),
        new Shelf(),
        new Shelf(),
        new Shelf()
    };
    
    
    public Bookcase()
    {
        //shelves = new Shelf[NUM_SHELVES];
    }
    
    
    ////
    // Getters (no set methods)
    public Shelf[] getShelves() { return shelves; }
    

    ////
    // Other methods
    
    // Add a book
    public static boolean addBookToBookcase(Book booktoAdd)
    {
        int i = 0;
        while (i < shelves.length)
        {
            if (shelves[i].addBookToShelf(booktoAdd))
            {
                return true;
            }
            i++;
        }
        // bookcase is full
        System.out.println("No room on this bookcase to add " + booktoAdd);
        return false;
    }

    // Remove a book when we know the exact Book object to remove
    public static Book removeBook(Book givenBook)
    {
        int i = 0;
        Book desiredBook = null;
        while (i < shelves.length && desiredBook == null)
        {
            desiredBook = shelves[i].removeBook(givenBook);
            i++;
        }
        if (desiredBook == null)
        {
            System.out.println("Sorry! No matches found.");
        }
        return desiredBook;
    }
    // Remove a book when we know its ISBN
    public static Book removeBookByISBN(int givenISBN)
    {
        int i = 0;
        Book desiredBook = null;
        while (i < shelves.length && desiredBook == null)
        {
            desiredBook = shelves[i].removeBookByISBN(givenISBN);
            i++;
        }
        if (desiredBook == null)
        {
            System.out.println("Sorry! No matches found.");
        }
        return desiredBook;
    }

    // Remove a book when we know its title. If there are multiple books
    // with the same given title, this method will remove the first one
    public static Book removeBookByTitle(String givenTitle)
    {
        int i = 0;
        Book desiredBook = null;
        while (i < shelves.length && desiredBook == null)
        {
            desiredBook = shelves[i].removeBookByTitle(givenTitle);
            i++;
        }
        if (desiredBook == null)
        {
            System.out.println("Sorry! No matches found.");
        }
        return desiredBook;
    }

    // Remove a book when we know its author. If there are multiple books
    // with the same given author, this method will remove the first one
    public static Book removeBookByAuthor(String givenAuthor)
    {
        int i = 0;
        Book desiredBook = null;
        while (i < shelves.length && desiredBook == null)
        {
            desiredBook = shelves[i].removeBookByAuthor(givenAuthor);
            i++;
        }
        if (desiredBook == null)
        {
            System.out.println("Sorry! No matches found.");
        }
        return desiredBook;
    }
}