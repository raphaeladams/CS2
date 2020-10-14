package clothing.types.subclasses;

import clothing.types.Accessories;

public class Tie extends Accessories
{    
    //constructors
    public Tie(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //other methods
    public boolean isCasual()
    {
        return false;
    }
}