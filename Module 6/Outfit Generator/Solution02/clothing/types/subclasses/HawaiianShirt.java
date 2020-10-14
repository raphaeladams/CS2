package clothing.types.subclasses;

import clothing.types.Shirt;

public class HawaiianShirt extends Shirt
{    
    //constructors
    public HawaiianShirt(String newName, String newColor)
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