//package data;

import java.util.ArrayList;

public class Article
{
    private String title;
    private String authorName;
    private Issue issue;

    public Article(String newTitle, String newAuthorName)
    {
        this(newTitle, newAuthorName, null); 
        // an article can be made independently, without being part of an issue
    }
    
    public Article(String newTitle, String newAuthorName, Issue newIssue)
    {
        title = newTitle;
        authorName = newAuthorName;
        issue = newIssue;
    }

    // Once an Article object is created, it should not change;
    // therefore, we have only getters and no setters
    public String getTitle() { return title; }
    public String getAuthorName() { return authorName; }
    public Issue getIssue() { return issue; }


    // Add to a list of authors and the num of articles they've written
    public void authorArticleCount(ArrayList<Author> authors)
    {
        int i = 0;
        while (i < authors.size())
        {
            if (getAuthorName().equals(authors.get(i).getName()))
            {
                authors.get(i).increaseNumArticles(1);
                break;
            }
            i++;
        }
        if (i >= authors.size())
        {
            // We've made it through the whole list without finding
            // a matching author; add this one
            Author newAuthor = new Author(getAuthorName());
            authors.add(newAuthor);
        }
        
    }

    ////
    // toString
    public String toString()
    {
        if (getIssue() != null)
        {
            return authorName + ". " + title + ". " + getIssue().getJournal().getTitle() + 
                ", " + getIssue().getVolNum() + "(" + getIssue().getIssueNum() + 
                "), " + getIssue().getYearPublished();
        }
        else
        {
            return authorName + ". " + title + ". Independent";
        }
    }
}