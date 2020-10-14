package clothing.types.subclasses;

import clothing.types.Outerwear;

public class WinterJacket extends Outerwear
{    
    //constructors
    public WinterJacket(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //other methods
    public boolean isSummer()
    {
        return false;
    }
}