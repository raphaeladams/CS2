public abstract class Outerwear extends Clothing //implements Season
{
    //attributes
    
    //constructors
    protected Outerwear(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //getters / setters
    //public String getName() { return name; }
    //public String getColor() { return color; }

    //other methods
    public abstract boolean isSummer();

    //toString
    public String toString()
    {
        return "Name: " + name + ", Color: " + color + ", Summer wear: " + isSummer();
    }
}