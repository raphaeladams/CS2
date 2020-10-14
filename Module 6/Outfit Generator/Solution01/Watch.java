public class Watch extends Accessories //implements DressCode
{
    //attributes
    
    //constructors
    protected Watch(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //getters / setters
    //public String getName() { return name; }
    //public String getColor() { return color; }

    //other methods
    public boolean isCasual()
    {
        return true;
    }
}