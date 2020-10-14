public class Library
{
    //attributes
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
    
    // Constructor
    public Library()
    {
        //shelves = new Shelf[NUM_SHELVES];
    }
    
    
    ////
    // Getters (no set methods)
    public Shelf[] getShelves() { return shelves; }
    

    ////
    // Other methods
    // static method to locate a book with the ISBN number??
}