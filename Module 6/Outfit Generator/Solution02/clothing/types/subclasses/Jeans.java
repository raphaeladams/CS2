package clothing.types.subclasses;

import clothing.types.Pants;

public class Jeans extends Pants
{    
    //constructors
    public Jeans(String newName, String newColor)
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