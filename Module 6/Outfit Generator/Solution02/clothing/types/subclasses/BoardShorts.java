package clothing.types.subclasses;

import clothing.types.Pants;

public class BoardShorts extends Pants
{    
    //constructors
    public BoardShorts(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //other methods
    public boolean isPatterned()
    {
        return true;
    }
    public boolean isCasual()
    {
        return true;
    }
    public boolean isSummer()
    {
        return true;
    }
}