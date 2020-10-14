package clothing.types.subclasses;

import clothing.types.Shoes;

public class Sandals extends Shoes
{    
    //constructors
    public Sandals(String newName, String newColor)
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
        return true;
    }
    public boolean isSummer()
    {
        return true;
    }
}