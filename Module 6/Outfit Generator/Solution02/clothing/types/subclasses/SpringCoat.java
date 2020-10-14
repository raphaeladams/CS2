package clothing.types.subclasses;

import clothing.types.Outerwear;

public class SpringCoat extends Outerwear
{    
    //constructors
    public SpringCoat(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //other methods
    public boolean isSummer()
    {
        return false;
    }
}