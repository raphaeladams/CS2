package clothing.types.subclasses;

import clothing.types.Accessories;

public class Cummerbund extends Accessories 
{    
    //constructors
    public Cummerbund(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //other methods
    public boolean isCasual()
    {
        return false;
    }
}