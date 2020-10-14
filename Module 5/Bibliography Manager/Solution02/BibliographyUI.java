//package ui;

//import data.BibliographyDatabase;
import java.util.ArrayList;
import java.util.Scanner;

class BibliographyUI
{
    private BibliographyDatabase bibliography;
    
    BibliographyUI(BibliographyDatabase newBibliography)
    {
        bibliography = newBibliography;
    }

    //report all Articles (in any issue of any journal) from a given year
    void reportArticlesFromYear()
    {
        System.out.print("What year are you interested in? ");
        Scanner yearInput = new Scanner(System.in);
        int year = yearInput.nextInt();

        System.out.println("Here are the articles from " + year + ":");
        if (!bibliography.printJournalArticlesFromYear(year))
        {
            System.out.println("No articles from the year " + year);
        }
    }

    //add an Article to a given Issue (by specifying the title and author)
    void addArticleToIssue()
    {
        ArrayList<Issue> issueMasterList = new ArrayList<Issue>();
        bibliography.addToIssueMasterList(issueMasterList);

        if (issueMasterList.size() > 0)
        {
            System.out.println("Here are the available issues:");
            for (Issue i : issueMasterList)
            {
                System.out.println("\t" + (issueMasterList.indexOf(i)+1) + ") " + i);
            }
    
            System.out.print("What issue would you like to add to? ");
            Scanner indexInput = new Scanner(System.in);
            int choiceIndex = indexInput.nextInt() - 1; // subtract for zero indexing

            while (choiceIndex < 0 || choiceIndex >= issueMasterList.size())
            {
                System.out.println("Sorry, that is not a valid choice.");
                System.out.print("What issue would you like to add to? ");
                indexInput = new Scanner(System.in);
                choiceIndex = indexInput.nextInt() - 1;
            }

            System.out.print("Please specify the article title: ");
            Scanner titleInput = new Scanner(System.in);
            String title = titleInput.nextLine();
        
            System.out.print("Please specify the article author: "); 
            Scanner authorInput = new Scanner(System.in);
            String author = authorInput.nextLine();
    
            issueMasterList.get(choiceIndex).addArticle(title, author);
        }
        else
        {
            System.out.println("No available issues");
        }
    }

    //find the name of the author with the highest number of Articles
    void findAuthorWithMostArticles()
    {
        if (bibliography.getMostFrequentAuthor() != null)
        {
            System.out.println("The most published author is " + bibliography.getMostFrequentAuthor());
        }
        else
        {
            System.out.println("Unable to find most published author.");
        }
    }
    
    // The main method will use this to kick start the UI
    void runProgram()
    {
        System.out.println("Welcome to the Bibliography Database!");
        bibliography.startProgram();
        
        while (!bibliography.isFinished())
        {
            System.out.print("You may perform the following operations:\n" + 
                "\t1) Find articles from a given year\n" + 
                "\t2) Add an article to an issue\n" + 
                "\t3) Find the most-published author\n" + 
                "\t4) Exit\n" + 
                "Please enter your choice (1, 2, or 3): ");
            
            // Get the user's choice
            Scanner input = new Scanner(System.in);
            int choiceIndex = input.nextInt() - 1; // subtract for zero indexing

            switch (choiceIndex)
            {
                case 0:
                    reportArticlesFromYear();
                    break;
                case 1:
                    addArticleToIssue();
                    break;
                case 2:
                    findAuthorWithMostArticles();
                    break;
                case 3:
                    System.out.println("Bye!");
                    bibliography.stopProgram();
                    break;
                default:
                    System.out.println("Sorry, that is not a valid choice.");
            }
        }
    }   
    
    public static void main(String[] args)
    {
        // Make a new bibliography and kickstart it
        ArrayList<Journal> journalList = new ArrayList<Journal>();
        journalList = Journal.getSampleJournals();

        BibliographyDatabase newBibliography = new BibliographyDatabase("BIBLIOGRAPHY");
        newBibliography.addListOfJournals(journalList);

        BibliographyUI ui = new BibliographyUI(newBibliography);
        ui.runProgram();
    }
}