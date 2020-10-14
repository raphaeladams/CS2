package clothing.types;

import clothing.Clothing;
import interfaces.Season;

public abstract class Outerwear extends Clothing implements Season
{    
    //constructors
    public Outerwear(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //toString
    public String toString()
    {
        return super.toString() + ", Summer wear: " + isSummer();
    }
}