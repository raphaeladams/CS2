//package data;

import java.util.ArrayList;

public class BibliographyDatabase
{
    private String title;
    private ArrayList<Article> independentArticles; // for articles that don't belong to an issue
    private ArrayList<Journal> journals;

    // Tracks whether a program is in progress or not
    private boolean inProgress;
    
    
    public BibliographyDatabase(String newTitle)
    {
        title = newTitle;
        independentArticles = new ArrayList<Article>();
        journals = new ArrayList<Journal>();
    }

    // Borrowed from BranchingStory example
    // Start program
    public void startProgram()
    { 
        inProgress = true;
    }
    
    // Stop program
    public void stopProgram()
    {
        inProgress = false;
    }   
    
    // Is the program finished?
    public boolean isFinished()
    {
        return !inProgress;
    }


    // add an article
    public void addArticle(Article article)
    {
        if (article.getIssue() == null)
        {
            independentArticles.add(article);
            System.out.println(article + " added to Independent Section");
        }
        else
        {
            addJournal(article.getIssue().getJournal());
            article.getIssue().getJournal().addIssue(article.getIssue());
            article.getIssue().addArticle(article);
        }
    }

    // remove an article
    public void removeArticle(Article article)
    {
        if (article.getIssue() == null && !independentArticles.contains(article))
        {
            System.out.println(article + " is not in " + toString() + ", can't remove");
        }
        else if (article.getIssue() == null)
        {
            independentArticles.remove(article);
            //System.out.println(article + " removed from Independent Section");
        }
        else
        {
            article.getIssue().removeArticle(article);
        }
    }
    
    // add an issue
    public void addIssue(Issue issue)
    {
        addJournal(issue.getJournal());
        issue.getJournal().addIssue(issue);
    }

    // remove an issue
    public void removeIssue(Issue issue)
    {
        issue.getJournal().removeIssue(issue);
    }

    // Add a new journal to the bibliography without having to know
    // how they are being represented
    public void addJournal(String title)
    {
        Journal newJournal = new Journal(title);
        journals.add(newJournal);
        //System.out.println(newJournal + " added");
    }

    //Add a journal that's already been created
    public void addJournal(Journal journal)
    {
        if (journals.contains(journal))
        {
            System.out.println(journal + " already in " + toString() + ", can't add again");
        }
        else
        {
            journals.add(journal);
            //System.out.println(journal + " added");
        }
    }

    // remove a journal
    public void removeJournal(Journal journal)
    {
        if (!journals.contains(journal))
        {
            System.out.println(journal + " is not in " + toString() + ", can't remove");
        }
        else
        {
            journals.remove(journal);
            //System.out.println(journal + " removed");
        }
    }

    // add journals from a list
    public void addListOfJournals(ArrayList<Journal> listOfJournals)
    {
        for (Journal j : listOfJournals)
        {
            addJournal(j);
        }
    }


    // Print all articles in this bibliography from a given year
    public boolean printJournalArticlesFromYear(int givenYear)
    {
        boolean hasArticlesFromYear = false;
        for (Journal j : journals)
        {
            if (j.printIssueArticlesFromYear(givenYear))
            {
                hasArticlesFromYear = true;
            }
        }
        return hasArticlesFromYear;
    }


    // find and return the author with the most articles.
    // If multiple authors share the highest number of articles, 
    // return the first one
    public Author getMostFrequentAuthor()
    {
        ArrayList<Author> authors = new ArrayList<Author>();
        Author mostFrequentAuthor = null;
        
        for (Journal j : journals)
        {
            j.authorArticleCount(authors);
        }
        
        for (Article a : independentArticles)
        {
            a.authorArticleCount(authors);
        }
        
        for (Author a : authors)
        {
            if (mostFrequentAuthor == null || 
                a.getNumArticles() > mostFrequentAuthor.getNumArticles())
            {
                mostFrequentAuthor = a;
            }
        }
        
        return mostFrequentAuthor;
    }


    // Add all journals' included issues to a master issue list
    public void addToIssueMasterList(ArrayList<Issue> issueMasterList)
    {
        for (Journal j : journals)
        {
            j.addToIssueMasterList(issueMasterList);
        }
    }


    ////
    // toString
    public String toString()
    {
        return title;
    }
}