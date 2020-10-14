package data;

import java.util.ArrayList;

// Uses code/concepts from the Branching Story example

public class Scene
{
    // Attributes
    private String id;
    private String text;
    private ArrayList<Choice> choices;
    private boolean isEndScene;
    
    
    // Constructors
    public Scene(String newID)
    {
        this(newID, "", false);
    }
    
    public Scene(String newID, String newText)
    {
        this(newID, newText, false);
    }
    
    public Scene(String newID, String newText, boolean isEnd)
    {
        id = newID;
        text = newText;
        choices = new ArrayList<Choice>();
        isEndScene = isEnd;
    }
    
    
    // Getters and setters
    // We only want to be able to directly get the ID and text of a scene,
    // and update only the text.  The choices ArrayList should be completely
    // hidden from users of this class, because they should not care how
    // we keep implement choice tracking.
    public String getID() { return id; }
    public String getText() { return text; }
    public void setText(String newText) { text = newText; }
    
    
    // Other functions

    // This method allows users of the class to access information
    // about a given choice (the text to give the user, in this case)
    public String getNthChoiceText(int choiceIndex)
    {
        String text = "";
        
        if (choiceIndex < choices.size())
        {
            text = choices.get(choiceIndex).getText();
        }
        
        return text;
    }
    
    
    // This method allows users of the class to access information
    // about a given choice (the reference to the next scene, in
    // this case)
    public Scene getNthNextScene(int choiceIndex)
    {
        Scene scene = null;
        
        if (choiceIndex >= 0 && choiceIndex < choices.size())
        {
            scene = choices.get(choiceIndex).getNextScene();
        }
        
        return scene;
    }
    
    
    // The number of choices is the length of the choice list
    public int getNumChoices()
    {
        return choices.size();
    }
    
    
    // Is this a terminal node (i.e. no further choices)?
    public boolean hasNoChoices()
    {
        return choices.isEmpty();
    }
    
    
    // Is this the final scene in the program?
    public boolean isEndScene()
    {
        return isEndScene;
    }
    

    // Add a new choice to the scene without having to know
    // how they are being represented
    public void addChoice(String text, Scene nextScene)
    {
        choices.add(new Choice(text, nextScene));
    }
    
    
    public String toString()
    {
        return id + ": " + text;
    }
    
    
    // Allows a scene to be compared logically to any 
    // other object
    public boolean equals(Object o)
    {
        boolean result = false;
        if (o instanceof Scene)
        {
            Scene s = (Scene)o;
            result = id.equals(s.id);
        }
        return result;
    }
}