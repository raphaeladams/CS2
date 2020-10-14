package clothing.types.subclasses;

import clothing.types.Shoes;

public class BoatShoes extends Shoes 
{    
    //constructors
    public BoatShoes(String newName, String newColor)
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