//package data;

public class Choice
{
    private String text;
    private Scene nextScene;
    
    public Choice(String newText, Scene newNextScene)
    {
        text = newText;
        nextScene = newNextScene;
    }
    
    // Getters (no setters)
    public String getText() { return text; }
    public Scene getNextScene() { return nextScene; }
}