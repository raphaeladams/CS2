public class Raincoat extends Outerwear //implements Season
{
    //attributes
    
    //constructors
    protected Raincoat(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //getters / setters
    //public String getName() { return name; }
    //public String getColor() { return color; }

    //other methods
    public boolean isSummer()
    {
        return true;
    }
}