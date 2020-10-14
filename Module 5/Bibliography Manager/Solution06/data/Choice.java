package data;

// Uses code/concepts from the Branching Story example

public class Choice
{
    // Attributes
    private String text;
    private Scene nextScene;
    
    
    // Constructors
    public Choice(String newText, Scene newNextScene)
    {
        text = newText;
        nextScene = newNextScene;
    }
    
    
    // Getters (no setters)
    public String getText() { return text; }
    public Scene getNextScene() { return nextScene; }
}