package clothing;

public abstract class Clothing
{
    //attributes
    protected String name;
    protected String color;
    
    //constructors
    public Clothing(String newName, String newColor)
    {
        name = newName;
        color = newColor;
    }
    
    //getters / setters
    public String getName() { return name; }
    public String getColor() { return color; }

    //toString
    public String toString()
    {
        return "Name: " + name + ", Color: " + color;
    }
}