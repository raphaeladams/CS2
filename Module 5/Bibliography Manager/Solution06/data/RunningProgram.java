package data;

// Uses code/concepts from the Branching Story example

public class RunningProgram
{
    // Attributes
    private Scene firstScene;
    private Scene currentScene;
    private boolean inProgress; 
    
    
    // Constructors
    public RunningProgram(Scene newFirstScene)
    {
        firstScene = newFirstScene;
    }
    
    
    // Getters (no setters)
    // This is the only information outsiders need to access directly.
    // Everything else users need to do can be done through more
    // specific methods.
    public Scene getCurrentScene() { return currentScene; }
    
    
    // Other functions
    
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
}