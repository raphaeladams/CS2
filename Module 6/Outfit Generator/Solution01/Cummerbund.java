public class Cummerbund extends Accessories //implements DressCode
{
    //attributes
    
    //constructors
    protected Cummerbund(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //getters / setters
    //public String getName() { return name; }
    //public String getColor() { return color; }

    //other methods
    public boolean isCasual()
    {
        return false;
    }
}