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
        Article newArticle = new Article(title, author, this);
        articles.add(newArticle);
        //System.out.println(newArticle + " added");
    }

    //Add an article that's already been created
    public void addArticle(Article article)
    {
        if (article.getIssue() != this)
        {
            System.out.println(article + " doesn't belong to " + toString() + "!");
        } 
        else if (articles.contains(article))
        {
            System.out.println(article + " already added to " + toString() + ", can't add again");
        }
        else
        {
            articles.add(article);
            //System.out.println(article + " added");
        }
    }

    // Remove an article from the issue without having to know
    // how they are being represented
    public void removeArticle(Article article)
    {
        if (!articles.contains(article))
        {
            System.out.println(article + " is not in " + toString() + ", can't remove");
        }
        else 
        {
            articles.remove(article);
            //System.out.println(article + " removed");
        }
    }

    // Print all articles from an issue
    public void printAllArticles()
    {
        for (Article a : articles)
        {
            System.out.println("\t" + a);
        }
    }


    // Add to a list of authors and the num of articles they've written
    public void authorArticleCount(ArrayList<Author> authors)
    {
        for (Article a : articles)
        {
            a.authorArticleCount(authors);
        }
    }

    ////
    // toString
    public String toString()
    {
        return journal.getTitle() + ", Volume " + volNum + ", Issue " + issueNum;
    }
}