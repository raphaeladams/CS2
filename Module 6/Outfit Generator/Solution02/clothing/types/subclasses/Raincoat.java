package clothing.types.subclasses;

import clothing.types.Outerwear;

public class Raincoat extends Outerwear
{    
    //constructors
    public Raincoat(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //other methods
    public boolean isSummer()
    {
        return true;
    }
}