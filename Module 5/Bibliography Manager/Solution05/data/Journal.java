package data;

import java.util.ArrayList;

public class Journal
{
    private String title;
    private ArrayList<Issue> issues;
    
    public Journal(String newTitle)
    {
        title = newTitle;
        issues = new ArrayList<Issue>();
    }
    
    // Once a Journal object is created, it should not change;
    // therefore, we have only getters and no setters. 
    // The issues ArrayList should be completely hidden
    public String getTitle() { return title; }


    // Add a new issue to the journal without having to know
    // how they are being represented
    public void addIssue(int yearPublished, int volNum, int issueNum)
    {
        Issue newIssue = new Issue(yearPublished, volNum, issueNum, this);
        issues.add(newIssue);
        //System.out.println(newIssue + " added to " + toString());
    }

    //Add an issue that's already been created
    public void addIssue(Issue issue)
    {
        if (issue.getJournal() != this)
        {
            System.out.println(issue + " doesn't belong to " + toString() + "!");
        }
        else if (issues.contains(issue))
        {
            System.out.println(issue + " already added to " + toString() + ", can't add again"); 
        }
        else
        {
            issues.add(issue);
            //System.out.println(issue + " added to " + toString());
        }
    }

    // Remove an issue from the journal without having to know
    // how they are being represented
    public void removeIssue(Issue issue)
    {
        if (!issues.contains(issue))
        {
            System.out.println(issue + " not in " + toString() + ", can't remove");
        }
        else
        {
            issues.remove(issue);
            //System.out.println(issue + " removed from " + toString());
        }
    }

    // Print all articles in this journal from a given year
    public boolean printIssueArticlesFromYear(int givenYear)
    {
        boolean hasArticlesFromYear = false;
        for (Issue i : issues)
        {
            if (i.getYearPublished() == givenYear)
            {
                hasArticlesFromYear = true;
                i.printAllArticles();
            }
        }
        return hasArticlesFromYear;
    }

    // Build a list of authors and the num of articles they've written
    public void authorArticleCount(ArrayList<Author> authors)
    {
        for (Issue i : issues)
        {
            i.authorArticleCount(authors);
        }
    }

    // Add all included issues to a master issue list
    public void addToIssueMasterList(ArrayList<Issue> issueMasterList)
    {
        for (Issue i : issues)
        {
            issueMasterList.add(i);
        }
    }

    ////
    // toString
    public String toString()
    {
        return title;
    }


    // Helper method:
    // Create 2 Journal objects that each contain 2 Issues 
    // that each contain 2 Articles
    public static ArrayList<Journal> getSampleJournals()
    {
        // Create journals
        Journal journal1 = new Journal("National Geographic");
        Journal journal2 = new Journal("Space: Science & Technology");

        // Add 2 issues to each journal
        Issue issue11 = new Issue(2020, 100, 3, journal1);
        Issue issue12 = new Issue(2010, 90, 4, journal1);  
        Issue issue21 = new Issue(2019, 7, 11, journal2);
        Issue issue22 = new Issue(2013, 1, 1, journal2);

        journal1.addIssue(issue11);
        journal1.addIssue(issue12);
        journal2.addIssue(issue21);
        journal2.addIssue(issue22);

        // Add 2 articles to each issue
        Article article111 = new Article("New Chimp Research", "Jane Goodall", issue11);
        Article article112 = new Article("Vibranium in Wakandan Plant Life", "Shuri", issue11);
        Article article121 = new Article("Rhinos", "Michael Stevenson", issue12);
        Article article122 = new Article("Tiger Habitats", "Michael Stevenson", issue12);
        Article article211 = new Article("Interstellar", "Christopher Nolan", issue21);
        Article article212 = new Article("2001 Space Travel", "Stanley Kubrick", issue21);
        Article article221 = new Article("Is Hyperspace Possible?", "George Lucas", issue22);
        Article article222 = new Article("Life on Vulcan", "Leonard Nimoy", issue22);

        issue11.addArticle(article111);
        issue11.addArticle(article112);
        issue12.addArticle(article121);
        issue12.addArticle(article122);
        issue21.addArticle(article211);
        issue21.addArticle(article212);
        issue22.addArticle(article221);
        issue22.addArticle(article222);

        ArrayList<Journal> journals = new ArrayList<Journal>();
        journals.add(journal1);
        journals.add(journal2);

        return journals;
    }
}