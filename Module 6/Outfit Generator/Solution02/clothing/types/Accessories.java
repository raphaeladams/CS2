package clothing.types;

import clothing.Clothing;
import interfaces.DressCode;

public abstract class Accessories extends Clothing implements DressCode
{   
    //constructors
    public Accessories(String newName, String newColor)
    {
        super(newName, newColor);
    }

    //toString
    public String toString()
    {
        return super.toString() + ", Casual: " + isCasual();
    }
}