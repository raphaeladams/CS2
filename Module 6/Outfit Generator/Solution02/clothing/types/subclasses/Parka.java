package clothing.types.subclasses;

import clothing.types.Outerwear;

public class Parka extends Outerwear
{    
    //constructors
    public Parka(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //other methods
    public boolean isSummer()
    {
        return false;
    }
}