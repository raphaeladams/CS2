public abstract class Clothing
{
    //attributes
    protected String name;
    protected String color;
    
    //constructors
    protected Clothing(String newName, String newColor)
    {
        name = newName;
        color = newColor;
    }
    
    //getters / setters
    public String getName() { return name; }
    public String getColor() { return color; }

    //other methods

    //toString
    public String toString()
    {
        return "Name: " + name + ", Color: " + color;
    }
}