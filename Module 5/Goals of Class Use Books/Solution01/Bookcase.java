public class Bookcase
{
    private static final int NUM_SHELVES = 5;
    private static final int SHELF_CAPACITY = 10;

    private static int CURR_SHELF_NUM = 0;
    private static int CURR_SHELF_POSITION = 0;
    
    private Book[][] books; // 2D array to illustrate the separate shelves and shelf capacities
    //TODO are 2D arrays the best way to handle this? They're confusing

    //TODO do we need another class(es), maybe a Shelf class?
    
    
    public Bookcase()
    {
        books = new Book[NUM_SHELVES][SHELF_CAPACITY];
    }
    
    
    ////
    // Getters (no set methods)
    public Book[][] getBooks() { return books; }
    

    ////
    // Other methods
    
    // Add a book -> use book's shelfNum and shelfPosition. If the book doesn't have either or both, 
    // assign the book the next free space in the array and put it there
    public void addBook(Book booktoAdd)
    {
        if (booktoAdd.getShelfNumber() == -1 || booktoAdd.getShelfPosition() == -1)
        {
            // book has not yet been assigned shelf space
            if (CURR_SHELF_NUM < NUM_SHELVES && CURR_SHELF_POSITION < SHELF_CAPACITY)
            {
                // we're in the middle of one of the shelves
                booktoAdd.assignShelfSpace(CURR_SHELF_NUM, CURR_SHELF_POSITION);
                books[CURR_SHELF_NUM][CURR_SHELF_POSITION++] = booktoAdd;
            }
            else if (CURR_SHELF_NUM < (NUM_SHELVES - 1))
            {
                // we've passed the end of the current shelf, go to the next shelf
                CURR_SHELF_POSITION = 0;
                booktoAdd.assignShelfSpace(++CURR_SHELF_NUM, CURR_SHELF_POSITION);
                books[CURR_SHELF_NUM][CURR_SHELF_POSITION++] = booktoAdd;
            }
            else
            {
                // all shelves are full
                System.out.println("No room on this bookcase to add " + booktoAdd);
            }
        }
        else if (booktoAdd.getShelfNumber() >= 0 && 
            booktoAdd.getShelfNumber() < NUM_SHELVES && 
            booktoAdd.getShelfPosition() >= 0 && 
            booktoAdd.getShelfPosition() < SHELF_CAPACITY)
        {
            // book has assigned shelf space, and it's somewhere on this bookcase
            books[booktoAdd.getShelfNumber()][booktoAdd.getShelfPosition()] = booktoAdd;
        }
        else
        {
            System.out.println(booktoAdd + " isn't assigned a space on this bookcase.");
            // TODO error handling not necessary here; internal methods
        }
    }

    // Remove a book when we know the exact Book object to remove
    public Book removeBook(Book bookToRemove)
    {
        if (bookToRemove.getShelfNumber() >= 0 && 
            bookToRemove.getShelfNumber() < NUM_SHELVES && 
            bookToRemove.getShelfPosition() >= 0 && 
            bookToRemove.getShelfPosition() < SHELF_CAPACITY &&
            books[bookToRemove.getShelfNumber()][bookToRemove.getShelfPosition()] == bookToRemove)
        {
            books[bookToRemove.getShelfNumber()][bookToRemove.getShelfPosition()] = null;
            return bookToRemove;
        }
        System.out.println("Sorry! No matches found.");
        return null;
    }

    //TODO make more specific methods removeBookByISBN, removeBookByTitle, removeBookByAuthor
    // Remove a book when we know its ISBN
    public Book removeBook(int desiredISBN)
    {
        for (Book[] thisShelf : books)
        {
            for (Book thisBook : thisShelf)
            {
                if (thisBook != null && thisBook.getISBN() == desiredISBN)
                {
                    books[thisBook.getShelfNumber()][thisBook.getShelfPosition()] = null;
                    return thisBook;
                }
            }
        }
        System.out.println("Sorry! No matches found.");
        return null;
    }

    // Remove a book when we know its title or author. If there are multiple books
    // with the same given title/author, this method will remove the first one
    public Book removeBook(String desiredTitleOrAuthor)
    {
        for (Book[] thisShelf : books)
        {
            for (Book thisBook : thisShelf)
            {
                if (thisBook != null && 
                    (thisBook.getTitle().equals(desiredTitleOrAuthor) || 
                    thisBook.getAuthor().equals(desiredTitleOrAuthor)))
                {
                    books[thisBook.getShelfNumber()][thisBook.getShelfPosition()] = null;
                    return thisBook;
                }
            }
        }
        System.out.println("Sorry! No matches found.");
        return null;
    }
}