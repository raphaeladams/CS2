package clothing.types.subclasses;

import clothing.types.Accessories;

public class Earrings extends Accessories 
{    
    //constructors
    public Earrings(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //other methods
    public boolean isCasual()
    {
        return true;
    }
}