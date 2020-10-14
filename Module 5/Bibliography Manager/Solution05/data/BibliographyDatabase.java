package data;

import java.util.ArrayList;

public class BibliographyDatabase
{
    private static ArrayList<Article> independentArticles = new ArrayList<Article>(); // for articles that don't belong to an issue
    private static ArrayList<Journal> journals = new ArrayList<Journal>();


    // Constructor
    private BibliographyDatabase()
    {
        // make class non-instantiable
    }


    // add an article
    public static void addArticle(Article article)
    {
        if (article.getIssue() == null)
        {
            independentArticles.add(article);
            //System.out.println(article + " added to Bibliography (Independent Section)");
        }
        else
        {
            article.getIssue().addArticle(article);
            article.getIssue().getJournal().addIssue(article.getIssue());
            addJournal(article.getIssue().getJournal());
        }
    }

    // remove an article
    public static void removeArticle(Article article)
    {
        if (article.getIssue() == null && !independentArticles.contains(article))
        {
            System.out.println(article + " is not in Bibliography, can't remove");
        }
        else if (article.getIssue() == null)
        {
            independentArticles.remove(article);
            //System.out.println(article + " removed from Bibliography (Independent Section)");
        }
        else
        {
            article.getIssue().removeArticle(article);
        }
    }
    
    // add an issue
    public static void addIssue(Issue issue)
    {
        issue.getJournal().addIssue(issue);
        addJournal(issue.getJournal());
    }

    // remove an issue
    public static void removeIssue(Issue issue)
    {
        issue.getJournal().removeIssue(issue);
    }

    // Add a new journal to the bibliography without having to know
    // how they are being represented
    public static void addJournal(String title)
    {
        Journal newJournal = new Journal(title);
        journals.add(newJournal);
        //System.out.println(newJournal + " added to Bibliography");
    }

    //Add a journal that's already been created
    public static void addJournal(Journal journal)
    {
        if (journals.contains(journal))
        {
            System.out.println(journal + " already in Bibliography, can't add again");
        }
        else
        {
            journals.add(journal);
            //System.out.println(journal + " added to Bibliography");
        }
    }

    // remove a journal
    public static void removeJournal(Journal journal)
    {
        if (!journals.contains(journal))
        {
            System.out.println(journal + " is not in Bibliography, can't remove");
        }
        else
        {
            journals.remove(journal);
            //System.out.println(journal + " removed from Bibliography");
        }
    }

    // add journals from a list
    public static void addListOfJournals(ArrayList<Journal> listOfJournals)
    {
        for (Journal j : listOfJournals)
        {
            addJournal(j);
        }
    }


    // Print all articles in this bibliography from a given year
    public static boolean printJournalArticlesFromYear(int givenYear)
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
    public static Author getMostFrequentAuthor()
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


    // Return master list of all journals' included issues
    public static ArrayList<Issue> getIssueMasterList()
    {
        ArrayList<Issue> issueMasterList = new ArrayList<Issue>();
        for (Journal j : journals)
        {
            j.addToIssueMasterList(issueMasterList);
        }
        return issueMasterList;
    }
}