//package data;

public class Author
{
    private String name;
    private int numArticles;

    public Author(String newName)
    {
        name = newName;
        numArticles = 1;
    }
    
    // Getters (no setters)
    public String getName() { return name; }
    public int getNumArticles() { return numArticles; }

    // increase an author's number of published articles
    public void increaseNumArticles(int givenNum)
    {
        numArticles += givenNum;
    }

    ////
    // toString
    public String toString()
    {
        return name;
    }
}