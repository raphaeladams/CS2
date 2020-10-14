package clothing.types.subclasses;

import clothing.types.Shoes;

public class Nikes extends Shoes
{    
    //constructors
    public Nikes(String newName, String newColor)
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
        return false;
    }
}