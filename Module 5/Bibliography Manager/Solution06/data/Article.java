package data;

import java.util.ArrayList;

public class Article
{
    // Attributes
    private String title;
    private String authorName;
    private Issue issue;

    
    // Constructors
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

    
    // Getters (no setters)
    public String getTitle() { return title; }
    public String getAuthorName() { return authorName; }
    public Issue getIssue() { return issue; }


    // Other functions
    
    // Build a list of authors and the num of articles they've written
    // (hashmaps would be great for this!)
    public void addToAuthorMasterList(ArrayList<Author> authors)
    {
        int i = 0;
        while (i < authors.size())
        {
            if (authorName.equals(authors.get(i).getName()))
            {
                authors.get(i).increaseNumArticles(1);
                return;
            }
            i++;
        }
        // We've made it through the whole list without finding
        // a matching author; add this one
        authors.add(new Author(authorName)); 
    }

    
    // toString
    public String toString()
    {
        if (issue != null)
        {
            return authorName + ". " + title + ". " + issue.getJournalTitle() + 
                ", " + issue.getVolNum() + "(" + issue.getIssueNum() + 
                "), " + issue.getYearPublished();
        }
        else
        {
            return authorName + ". " + title + ". Independent";
        }
    }
}