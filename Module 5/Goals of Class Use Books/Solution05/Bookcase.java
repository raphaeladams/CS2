public class Bookcase
{
    private static final int NUM_SHELVES = 5;    
    private static Shelf[] shelves = new Shelf[NUM_SHELVES];
    static
    {
        for (int i = 0; i < shelves.length; i++)
        {
            shelves[i] = new Shelf();
        }
    }
       
    // Constructor
    private Bookcase()
    {
        // make the class non-instantiable, these are static
        // attributes & methods for modifying Shelf data
    }
           
    
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

    // Remove a book when we know its title. If there are multiple books
    // with the same given title, this method will remove the first one
    public static Book removeBook(String givenTitle)
    {
        int i = 0;
        while (i < shelves.length)
        {
            Book desiredBook = shelves[i].removeBook(givenTitle);
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