package ui;

import data.RunningProgram;
import data.BibliographyDatabase;
import data.Journal;
import data.Issue;
import data.Scene;

import java.util.Scanner;

// Uses code/concepts from the Branching Story example

class ProgramUI
{
    // Attributes
    private RunningProgram program;
    
    
    // Constructors
    ProgramUI(RunningProgram newProgram)
    {
        program = newProgram;
    }


    // Other functions
    
    // Report all Articles (in any issue of any journal) from a given year
    void reportArticlesFromYear()
    {
        System.out.print("What year are you interested in? ");
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();

        System.out.println("Here are the articles from " + year + ":");
        if (!BibliographyDatabase.printArticlesFromYear(year))
        {
            System.out.println("\tNo articles from " + year);
        }
    }

    
    // Add an Article to a given Issue (by specifying title and author)
    void addArticleToIssue(int issueIndex)
    {
        System.out.print("Please specify the article title: ");
        Scanner input = new Scanner(System.in);
        String title = input.nextLine();
    
        System.out.print("Please specify the article author: "); 
        input = new Scanner(System.in);
        String author = input.nextLine();

        BibliographyDatabase.addArticle(title, author, issueIndex);
    }

    
    // Find the name of the author with the highest number of Articles
    void findAuthorWithMostArticles()
    {
        if (BibliographyDatabase.getMostFrequentAuthor() != null)
        {
            System.out.println("The most published author is " + 
                BibliographyDatabase.getMostFrequentAuthor());
        }
        else
        {
            System.out.println("Unable to find most published author.");
        }
    }

    
    // The main method will use this to kick start the UI
    void runProgram()
    {
        program.startProgram();
        System.out.println("Welcome to the Bibliography Database!");
        int choiceIndex = -1;
        
        while (!program.isFinished())
        {
            // Print out the scene text
            if (program.getCurrentScene().getText() != null)
            {
                System.out.print(program.getCurrentScene().getText());
            }
            
            // carry out specific scene functions here
            switch (program.getCurrentScene().getID())
            {
                case "FindArticles":
                    reportArticlesFromYear();
                    break;
                case "EnterArticleInfo":
                    addArticleToIssue(choiceIndex);
                    break;
                case "FindAuthor":
                    findAuthorWithMostArticles();
                    break;
                default:
                    //do nothing
            }
            
            // End, loop over, or display choices, depending on current scene
            if (program.getCurrentScene().isEndScene())
            {
                program.stopProgram();
            }
            else if (program.getCurrentScene().hasNoChoices())
            {
                program.startProgram();
            }
            else
            {
                // Choices: display the options
                for (int i=0; i < program.getCurrentScene().getNumChoices(); i++)
                {
                    System.out.println("\t" + (i+1) + ") " + program.getCurrentScene().getNthChoiceText(i));
                }
                System.out.print("Please enter your choice: ");
                
                // Get the user's choice
                Scanner input = new Scanner(System.in);
                choiceIndex = input.nextInt() - 1; // subtract for zero indexing
                
                if (!program.makeChoice(choiceIndex))
                {
                    System.out.println("Sorry, that is not a valid choice.");
                }
            }
        }
    }



    // A static helper method that returns the scenes/choices we will use
    static RunningProgram getProgram()
    {
        Scene scene1 = new Scene("MainMenu",
                                 "\nYou may perform the following operations:\n"); // has a choice

        Scene scene2 = new Scene("FindArticles","\n"); // has a function

        Scene scene3 = new Scene("AddArticle",
                                 "\nHere are the available issues:\n"); // has a choice

        Scene scene4 = new Scene("EnterArticleInfo", "\n"); // has a function

        Scene scene5 = new Scene("FindAuthor", "\n"); // has a function

        Scene scene6 = new Scene("End", "\nBye!\n", true); // end scene
        
        ///////////////////////////////////////////////////////////////
        
        scene1.addChoice("Find articles from a given year", scene2);
        scene1.addChoice("Add an article to an issue", scene3);
        scene1.addChoice("Find the most-published author", scene5);
        scene1.addChoice("Exit", scene6);

        for (Issue i : BibliographyDatabase.getIssueMasterList())
        {
            scene3.addChoice(i.toString(), scene4);
        }
        if (scene3.hasNoChoices())
        {
            scene3.setText("No available issues\n");
        }
        
        ///////////////////////////////////////////////////////////////
                         
        return new RunningProgram(scene1);
    }

    
    
    
    public static void main(String[] args)
    {
        BibliographyDatabase.addListOfJournals(Journal.getSampleJournals());

        // Make a new program and kickstart it
        ProgramUI ui = new ProgramUI(getProgram());
        ui.runProgram();
    }
}