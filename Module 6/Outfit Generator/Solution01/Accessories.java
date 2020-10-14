public abstract class Accessories extends Clothing //implements DressCode
{
    //attributes
    
    //constructors
    protected Accessories(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //getters / setters
    //public String getName() { return name; }
    //public String getColor() { return color; }

    //other methods
    public abstract boolean isCasual();

    //toString
    public String toString()
    {
        return "Name: " + name + ", Color: " + color + ", Casual: " + isCasual();
    }
}