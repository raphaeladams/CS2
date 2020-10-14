package clothing.types.subclasses;

import clothing.types.Pants;

public class Khakis extends Pants
{    
    //constructors
    public Khakis(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //other methods
    public boolean isPatterned()
    {
        return false;
    }
    public boolean isCasual()
    {
        return false;
    }
    public boolean isSummer()
    {
        return false;
    }
}