package data;

import java.util.ArrayList;

public class Journal
{
    // Attributes
    private String title;
    private ArrayList<Issue> issues;
    
    
    // Constructors 
    public Journal(String newTitle)
    {
        title = newTitle;
        issues = new ArrayList<Issue>();
    }
    
    
    // Getters (no setters)
    public String getTitle() { return title; }
    public ArrayList<Issue> getIssues() { return issues; }

    
    // Other functions
    
    // Add a new issue to the journal without having to know
    // how they are being represented
    public void addIssue(int yearPublished, int volNum, int issueNum)
    {
        issues.add(new Issue(yearPublished, volNum, issueNum, this));
    }

    
    // Add an issue that's already been created
    public void addIssue(Issue issue)
    {
        if (issue.getJournal() == this && !issues.contains(issue))
        {
            issues.add(issue);
        }
    }

    
    // Remove an issue from the journal without having to know
    // how they are being represented
    public boolean removeIssue(int volNum, int issueNum)
    {
        return issues.removeIf(issue -> 
            issue.getVolNum() == volNum && 
            issue.getIssueNum() == issueNum);
    }


    // Build a list of authors and the num of articles they've written
    public void addToAuthorMasterList(ArrayList<Author> authors)
    {
        for (Issue i : issues)
        {
            i.addToAuthorMasterList(authors);
        }
    }

    
    // Print all articles in this journal from a given year
    public boolean printArticlesFromYear(int givenYear)
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

    
    // Print all issues from this journal
    public void printAllIssues()
    {
        for (Issue i : issues)
        {
            System.out.println("\t" + i);
        }
    }

    
    // toString
    public String toString()
    {
        return title;
    }

    
    // Helper method:
    // Create 2 Journal objects that each contain 2 Issues, that each contain 2 Articles
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