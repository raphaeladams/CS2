public class Nikes extends Shoes //implements Pattern, DressCode, Season
{
    //attributes
    
    //constructors
    protected Nikes(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //getters / setters
    //public String getName() { return name; }
    //public String getColor() { return color; }

    //other methods
    public boolean isPatterned()
    {
        return true;
    }
    public boolean isCasual()
    {
        return true;
    }
    public boolean isSummer()
    {
        return false;
    }
}