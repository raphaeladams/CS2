package clothing.types;

import clothing.Clothing;
import interfaces.Pattern;
import interfaces.DressCode;
import interfaces.Season;

public abstract class Pants extends Clothing implements Pattern, DressCode, Season
{    
    //constructors
    public Pants(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //toString
    public String toString()
    {
        return super.toString() + ", Patterned: " + isPatterned() + 
            ", Casual: " + isCasual() + ", Summer wear: " + isSummer();
    }
}