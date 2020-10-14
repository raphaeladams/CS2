package clothing.types.subclasses;

import clothing.types.Shirt;

public class Vest extends Shirt
{
    
    //constructors
    public Vest(String newName, String newColor)
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