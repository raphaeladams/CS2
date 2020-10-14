public class TestClass
{
    public static void main(String args[]) 
    {
        //Bookcase restrictedSection = new Bookcase();
        int NUM_NEW_BOOKS = 51; // one too many for the bookcase
        
        for (int i = 0; i < NUM_NEW_BOOKS; i++)
        {
            //restrictedSection.addBookToBookcase(new Book("Title" + i, "Author" + i));
            Bookcase.addBookToBookcase(new Book("Title" + i, "Author" + i));
            // No room on this bookcase for Title50 by Author50: 1000000050
        }

        Reader harry = new Reader("Harry Potter");
        System.out.println(harry); // Reader: Harry Potter

        harry.returnBook(/*restrictedSection*/); // Harry Potter has no books to return.

        harry.takeBookByISBN(1000000001/*, restrictedSection*/);
        System.out.println(harry); // Reader: Harry Potter with Title1 by Author1: 1000000001

        harry.takeBookByISBN(1000000038/*, restrictedSection*/); 
        // Harry Potter already has Title1 by Author1: 1000000001. You must return a book before taking another!
        
        harry.returnBook(/*restrictedSection*/);
        System.out.println(harry); // Reader: Harry Potter

        harry.takeBookByAuthor("Author38"/*, restrictedSection*/);
        System.out.println(harry); // Reader: Harry Potter with Title38 by Author38: 1000000038

        harry.returnBook(/*restrictedSection*/);
        harry.takeBookByTitle("Title43"/*, restrictedSection*/);
        System.out.println(harry); // Reader: Harry Potter with Title43 by Author43: 1000000043

        harry.takeBookByISBN(1000000043/*, restrictedSection*/); // Harry Potter already has this book!

        Reader hermione = new Reader("Hermione Granger");
        hermione.takeBookByISBN(1000000043/*, restrictedSection*/); // Sorry! No matches found.
        hermione.takeBookByTitle("A History of Magic"/*, restrictedSection*/); // Sorry! No matches found.
        System.out.println(hermione); // Reader: Hermione Granger
    }
}