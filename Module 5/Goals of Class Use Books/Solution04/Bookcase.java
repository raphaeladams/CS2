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
            int freeSpaceIndex = shelves[i].findFreeSpace();
            if (freeSpaceIndex != -1)
            {
                shelves[i].addBook(freeSpaceIndex, booktoAdd);
                return true;
            }
            i++;
        }
        System.out.println("No room on this bookcase to add " + booktoAdd);
        return false;
    }

    // Remove a book when we know its title. If there are multiple books
    // with the same given title, this method will remove the first one
    public static Book removeBookByTitle(String givenTitle)
    {
        int i = 0;
        while (i < shelves.length)
        {
            int index = shelves[i].findIndexOfBook(givenTitle);
            if (index != -1)
            {
                return shelves[i].removeBook(index);
            }
            i++;
        }
        System.out.println("Sorry! No matches found.");
        return null;
    }
}