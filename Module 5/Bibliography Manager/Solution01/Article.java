//package data;

public class Article
{
    private String title;
    private String author;
    private Issue issue;
    
    public Article(String newTitle, String newAuthor, Issue newIssue)
    {
        title = newTitle;
        author = newAuthor;
        issue = newIssue;
        issue.addArticle(this); // is this good practice? 
    }
    
    // Once an Article object is created, it should not change;
    // therefore, we have only getters and no setters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public Issue getIssue() { return issue; }
}