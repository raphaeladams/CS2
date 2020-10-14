package clothing.types.subclasses;

import clothing.types.Shoes;

public class DressShoes extends Shoes
{    
    //constructors
    public DressShoes(String newName, String newColor)
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