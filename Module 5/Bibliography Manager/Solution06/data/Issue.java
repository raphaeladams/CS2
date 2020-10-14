package data;

import java.util.ArrayList;

public class Issue
{
    // Attributes
    private int yearPublished;
    private int volNum;
    private int issueNum;
    private ArrayList<Article> articles;
    private Journal journal;
    
    
    // Constructors
    public Issue(int newYearPublished, int newVolNum, int newIssueNum, Journal newJournal)
    {
        yearPublished = newYearPublished;
        volNum = newVolNum;
        issueNum = newIssueNum;
        articles = new ArrayList<Article>();
        journal = newJournal;
    }
    
    
    // Getters (no setters)
    public int getYearPublished() { return yearPublished; }
    public int getVolNum() { return volNum; }
    public int getIssueNum() { return issueNum; }
    public Journal getJournal() { return journal; }

    
    // Other functions
    
    // Return journal title
    public String getJournalTitle()
    {
        return journal.getTitle();
    }
    
    
    // Add a new article to the issue without having to know
    // how they are being represented
    public void addArticle(String title, String author)
    {
        articles.add(new Article(title, author, this));
    }

    
    // Add an article that's already been created
    public void addArticle(Article article)
    {
        if (article.getIssue() == this && !articles.contains(article))
        {
            articles.add(article);
        }
    }

    
    // Remove an article from the issue without having to know
    // how they are being represented
    public boolean removeArticle(String title, String author)
    {
        return articles.removeIf(article -> 
            article.getTitle().equals(title) && 
            article.getAuthorName().equals(author));
    }

    
    // Build a list of authors and the num of articles they've written
    public void addToAuthorMasterList(ArrayList<Author> authors)
    {
        for (Article a : articles)
        {
            a.addToAuthorMasterList(authors);
        }
    }

    
    // Print all articles from this issue
    public void printAllArticles()
    {
        for (Article a : articles)
        {
            System.out.println("\t" + a);
        }
    }

    
    // toString
    public String toString()
    {
        return getJournalTitle() + ", Volume " + volNum + ", Issue " + issueNum;
    }
}