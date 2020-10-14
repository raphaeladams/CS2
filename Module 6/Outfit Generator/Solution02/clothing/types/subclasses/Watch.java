package clothing.types.subclasses;

import clothing.types.Accessories;

public class Watch extends Accessories
{    
    //constructors
    public Watch(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //other methods
    public boolean isCasual()
    {
        return true;
    }
}