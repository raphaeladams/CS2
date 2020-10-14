//package data;

import java.util.ArrayList;

public class Issue
{
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
}