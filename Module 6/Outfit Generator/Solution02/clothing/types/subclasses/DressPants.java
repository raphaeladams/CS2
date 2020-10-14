package clothing.types.subclasses;

import clothing.types.Pants;

public class DressPants extends Pants
{    
    //constructors
    public DressPants(String newName, String newColor)
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