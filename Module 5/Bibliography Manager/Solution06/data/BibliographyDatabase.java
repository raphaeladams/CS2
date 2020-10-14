package data;

import java.util.ArrayList;

public class BibliographyDatabase
{
    // Attributes
    private static ArrayList<Article> independentArticles = new ArrayList<Article>(); 
    private static ArrayList<Journal> journals = new ArrayList<Journal>();
    private static ArrayList<Issue> issueMasterList = new ArrayList<Issue>();

    
    // Constructors
    private BibliographyDatabase()
    {
        // make class non-instantiable
    }

    
    // Getters (no setters)
    public static ArrayList<Issue> getIssueMasterList() { return issueMasterList; }


    // Other functions

    // Add a new article to a particular issue in issueMasterList
    public static void addArticle(String title, String author, int issueIndex)
    {
        issueMasterList.get(issueIndex).addArticle(title, author);
    }

    // Add an article that's already been created
    public static void addArticle(Article article)
    {
        Issue currentIssue = article.getIssue();
        
        if (currentIssue == null)
        {
            independentArticles.add(article);
        }
        else
        {            
            Journal currentJournal = currentIssue.getJournal();
            currentIssue.addArticle(article);
            currentJournal.addIssue(currentIssue);
            addJournal(currentJournal);
            
            if (!issueMasterList.contains(currentIssue))
            {
                issueMasterList.add(currentIssue);
            }
        }
    }

    
    // Remove an article
    public static boolean removeArticle(String title, String author)
    {
        // Check if it's in independent articles first
        if (independentArticles.removeIf(article -> 
            article.getTitle().equals(title) && 
            article.getAuthorName().equals(author)))
        {
            return true;
        }
        // If not, check if it's in any of the stored issues
        else 
        {
            for (Issue i : issueMasterList)
            {
                if (i.removeArticle(title, author))
                {
                    return true;
                }
            }
            return false;
        }
    }
    
    
    // Add an issue
    public static void addIssue(Issue issue)
    {
        Journal currentJournal = issue.getJournal();
        currentJournal.addIssue(issue);
        addJournal(currentJournal);
        
        if (!issueMasterList.contains(issue))
        {
            issueMasterList.add(issue);
        }
    }

    
    // Remove an issue
    public static boolean removeIssue(String journalTitle, int volNum, int issueNum)
    {
        for (Journal j: journals)
        {
            if (j.getTitle().equals(journalTitle) && j.removeIssue(volNum, issueNum))
            {
                issueMasterList.removeIf(issue -> 
                    issue.getJournalTitle().equals(journalTitle) &&
                    issue.getVolNum() == volNum && 
                    issue.getIssueNum() == issueNum);
                return true;
            }
        }
        return false;
    }

    
    // Add a new journal to the bibliography without having to know
    // how they are being represented
    public static void addJournal(String title)
    {
        journals.add(new Journal(title));
    }

    
    // Add a journal that's already been created
    public static void addJournal(Journal journal)
    {
        if (!journals.contains(journal))
        {
            journals.add(journal);
            issueMasterList.addAll(journal.getIssues());
        }
    }

    
    // Add journals from a list
    public static void addListOfJournals(ArrayList<Journal> listOfJournals)
    {
        for (Journal j : listOfJournals)
        {
            addJournal(j);
        }
    }

    
    // Remove a journal without having to know
    // how they are being represented
    public static boolean removeJournal(String title)
    {
        for (Journal j : journals)
        {
            if (j.getTitle().equals(title))
            {
                journals.remove(j);
                issueMasterList.removeAll(j.getIssues());
                return true;
            }
        }
        return false;
    }


    // Find and return the author with the most articles
    public static Author getMostFrequentAuthor()
    {
        ArrayList<Author> authorList = new ArrayList<Author>();
        Author mostFrequentAuthor = null;
        
        for (Journal j : journals)
        {
            j.addToAuthorMasterList(authorList);
        }
        
        for (Article a : independentArticles)
        {
            a.addToAuthorMasterList(authorList);
        }
        
        for (Author a : authorList)
        {
            if (mostFrequentAuthor == null || 
                a.getNumArticles() > mostFrequentAuthor.getNumArticles())
            {
                mostFrequentAuthor = a;
            }
        }
        
        return mostFrequentAuthor;
    }

    
    // Print all articles in the bibliography from a given year
    public static boolean printArticlesFromYear(int givenYear)
    {
        boolean hasArticlesFromYear = false;
        for (Journal j : journals)
        {
            if (j.printArticlesFromYear(givenYear))
            {
                hasArticlesFromYear = true;
            }
        }
        return hasArticlesFromYear;
    }


    // Print all journals in the bibliography
    public static void printAllJournals()
    {
        for (Journal j : journals)
        {
            System.out.println("\t" + j);
        }
    }

    
    // Print entire bibliography
    public static void printAll()
    {
        System.out.println("\n-----------------------------------");
        System.out.println("\nBIBLIOGRAPHY CONTENTS:\n\nJOURNALS:");
        printAllJournals();
        
        System.out.println("ISSUES:");
        for (Journal j : journals)
        {
            j.printAllIssues();
        }
        
        System.out.println("ARTICLES:");
        for (Issue i : issueMasterList)
        {
            i.printAllArticles();
        }
        for (Article a : independentArticles)
        {
            System.out.println("\t" + a);
        }
        System.out.println("\n-----------------------------------");
    }
}