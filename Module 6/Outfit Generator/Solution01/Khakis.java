public class Khakis extends Pants //implements Pattern, DressCode, Season
{
    //attributes
    
    //constructors
    protected Khakis(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //getters / setters
    //public String getName() { return name; }
    //public String getColor() { return color; }

    //other methods
    public boolean isPatterned()
    {
        return false;
    }
    public boolean isCasual()
    {
        return false;
    }
    public boolean isSummer()
    {
        return false;
    }
}