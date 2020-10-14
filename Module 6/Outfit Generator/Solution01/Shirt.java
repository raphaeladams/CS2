public abstract class Shirt extends Clothing implements Pattern, DressCode, Season
{
    //attributes
    
    //constructors
    protected Shirt(String newName, String newColor)
    {
        super(newName, newColor);
    }
    
    //getters / setters
    //public String getName() { return name; }
    //public String getColor() { return color; }

    //other methods
    //public abstract boolean isPatterned();
    //public abstract boolean isCasual();
    //public abstract boolean isSummer();

    //toString
    public String toString()
    {
        return "Name: " + name + ", Color: " + color + ", Patterned: " + isPatterned() + 
            ", Casual: " + isCasual() + ", Summer wear: " + isSummer();
    }
}