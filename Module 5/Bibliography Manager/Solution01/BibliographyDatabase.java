//package data;

import java.util.ArrayList;

public class BibliographyDatabase
{
    /*
    private int yearPublished;
    private int volNum;
    private int issueNum;
    private ArrayList<Article> articles;
    private Journal journal;
    
    public Issue(int newYearPublished, int newVolNum, int newIssueNum, Journal newJournal)
    {
        yearPublished = newYearPublished;
        volNum = newVolNum;
        issueNum = newIssueNum;
        articles = new ArrayList<Article>();
        journal = newJournal;
        journal.addIssue(this);
    }
    
    // Once an Issue object is created, it should not change;
    // therefore, we have only getters and no setters. 
    // The articles ArrayList should be completely hidden
    public int getYearPublished() { return yearPublished; }
    public int getVolNum() { return volNum; }
    public int getIssueNum() { return issueNum; }
    public Journal getJournal() { return journal; }
    

    
    // Add a new article to the issue without having to know
    // how they are being represented
    public void addArticle(String title, String author)
    {
        articles.add(new Article(title, author, this));
    }

    public void addArticle(Article article)
    {
        if (article.getIssue() != this)
        {
            System.out.println("This article doesn't belong to this issue!");
            return;
        }
        articles.add(article);
    }
    */

    // "Users of the class should be able to add or remove a particular article, issue, or journal, and to add a list of journals."
    // Does this mean they should be able to add/remove an article to an issue, an issue to a journal, etc? 
    // Or should they just be able to create/delete a new article, issue, etc? 


    // add an article
    public void addArticle(Article article, Issue issue)
    {
        issue.addArticle(article);
    }

    // remove an article
    
    // add an issue
    public void addIssue(Issue issue, Journal journal)
    {
        journal.addIssue(issue);
    }

    // remove an issue

    // add a journal

    // remove a journal

    // add a list of journals
    public ArrayList<Journal> addListOfJournals()
    {
        ArrayList<Journal> journals = new ArrayList<Journal>();
        return journals;
    }
}