package ui;

import data.RunningProgram;
import data.BibliographyDatabase;
import data.Issue;
import data.Journal;

import java.util.Scanner;
import java.util.ArrayList;


class ProgramUI
{
    private RunningProgram program;
    private BibliographyDatabase bibliography;
    
    ProgramUI(RunningProgram newProgram, BibliographyDatabase newBibliography)
    {
        program = newProgram;
        bibliography = newBibliography;
    }


    //report all Articles (in any issue of any journal) from a given year
    void reportArticlesFromYear()
    {
        Scanner yearInput = new Scanner(System.in);
        int year = yearInput.nextInt();

        System.out.println("Here are the articles from " + year + ":");
        if (!bibliography.printJournalArticlesFromYear(year))
        {
            System.out.println("\tNo articles from " + year);
        }
    }

    //add an Article to a given Issue (by specifying the title and author)
    void addArticleToIssue(int choiceIndex)
    {
        ArrayList<Issue> issueMasterList = new ArrayList<Issue>();
        bibliography.addToIssueMasterList(issueMasterList);

        if (!issueMasterList.isEmpty())
        {
            System.out.print("Please specify the article title: ");
            Scanner titleInput = new Scanner(System.in);
            String title = titleInput.nextLine();
        
            System.out.print("Please specify the article author: "); 
            Scanner authorInput = new Scanner(System.in);
            String author = authorInput.nextLine();
    
            issueMasterList.get(choiceIndex).addArticle(title, author);
            //TODO issue.addArticle(title, author); ??
            
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
            
            // If the program has choices to display, it will print them here; 
            // if not, it will either end or loop again
            if (program.getCurrentScene().getID().equals("End"))
            {
                program.stopProgram();
            }
            else if (program.getCurrentScene().isTerminal())
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
    
    
    
    public static void main(String[] args)
    {
        ArrayList<Journal> journalList = Journal.getSampleJournals();

        BibliographyDatabase newBibliography = new BibliographyDatabase("BIBLIOGRAPHY");
        newBibliography.addListOfJournals(journalList);

        // Make a new program and kickstart it
        ProgramUI ui = new ProgramUI(RunningProgram.getSampleProgram(newBibliography), newBibliography);
        ui.runProgram();
    }
}