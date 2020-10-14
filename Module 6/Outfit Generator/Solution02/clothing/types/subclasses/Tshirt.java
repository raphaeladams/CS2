package clothing.types.subclasses;

import clothing.types.Shirt;

public class Tshirt extends Shirt
{    
    //constructors
    public Tshirt(String newName, String newColor)
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