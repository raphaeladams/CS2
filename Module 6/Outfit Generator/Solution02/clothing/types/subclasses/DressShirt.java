package clothing.types.subclasses;

import clothing.types.Shirt;

public class DressShirt extends Shirt 
{    
    //constructors
    public DressShirt(String newName, String newColor)
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
        return false;
    }
    public boolean isSummer()
    {
        return false;
    }
}