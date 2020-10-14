//package data;

import java.util.ArrayList;

public class RunningProgram
{
    private Scene firstScene;
    private Scene currentScene;
    private boolean inProgress; 
    
    public RunningProgram(Scene newFirstScene)
    {
        firstScene = newFirstScene;
    }
    
    
    // This is the only information outsiders need to access directly.
    // Everything else users need to do can be done through more
    // specific methods.
    public Scene getCurrentScene() { return currentScene; }
    
    
    // Start program
    public void startProgram()
    { 
        currentScene = firstScene;
        inProgress = true;
    }
    
    // Stop program
    public void stopProgram()
    {
        inProgress = false;
    }   
    
    // Is the program finished?
    public boolean isFinished()
    {
        return !inProgress;
    }
    
    
    // Allows users of the program to make a choice within the 
    // current scene, returning whether the scene was successfully
    // moved forward.
    public boolean makeChoice(int choiceIndex)
    {
        Scene s = currentScene.getNthNextScene(choiceIndex);
        if (s != null)
        {
            currentScene = s;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    // A static helper method that returns an example program that we can use
    // for testing
    public static RunningProgram getSampleProgram(BibliographyDatabase bibliography)
    {
        Scene scene1 = new Scene("MainMenu",
                                 "You may perform the following operations:\n");

        Scene scene2 = new Scene("FindArticles",
                                 "What year are you interested in? ");

        Scene scene3 = new Scene("AddArticle",
                                 "Here are the available issues:\n");

        Scene scene4 = new Scene("EnterArticleInfo", null);

        Scene scene5 = new Scene("FindAuthor", null);

        Scene scene6 = new Scene("End", "Bye!\n");
        
        ///////////////////////////////////////////////////////////////
        
        scene1.addChoice("Find articles from a given year", scene2);
        scene1.addChoice("Add an article to an issue", scene3);
        scene1.addChoice("Find the most-published author", scene5);
        scene1.addChoice("Exit", scene6);

        ArrayList<Issue> issueMasterList = new ArrayList<Issue>();
        bibliography.addToIssueMasterList(issueMasterList);

        for (Issue i : issueMasterList)
        {
            scene3.addChoice(i.toString(), scene4);
        }
        
        
        ///////////////////////////////////////////////////////////////
                         
        RunningProgram program = new RunningProgram(scene1);
        
        return program;
    }
}