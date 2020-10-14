public class SpringCoat extends Outerwear //implements Season
{
    //attributes
    
    //constructors
    protected SpringCoat(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //getters / setters
    //public String getName() { return name; }
    //public String getColor() { return color; }

    //other methods
    public boolean isSummer()
    {
        return false;
    }
}