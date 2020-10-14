import java.util.ArrayList;
import java.util.Random;

public class OutfitGenerator
{
    //attributes
    protected String name;
    private ArrayList<Shirt> shirtsList;
    private ArrayList<Pants> pantsList;
    private ArrayList<Shoes> shoesList;
    private ArrayList<Outerwear> outerwearList;
    private ArrayList<Accessories> accessoriesList;
    
    //constructors
    protected OutfitGenerator(String newName)
    {
        name = newName;
        shirtsList = new ArrayList<Shirt>();
        pantsList = new ArrayList<Pants>();
        shoesList = new ArrayList<Shoes>();
        outerwearList = new ArrayList<Outerwear>();
        accessoriesList = new ArrayList<Accessories>();
    }
    
    //getters / setters
    public String getName() { return name; }

    
    //other methods
    protected void add(Clothing givenArticle)
    {
        if (givenArticle instanceof Shirt)
        {
            shirtsList.add((Shirt)givenArticle);
        }
        else if (givenArticle instanceof Pants)
        {
            pantsList.add((Pants)givenArticle);
        }
        else if (givenArticle instanceof Shoes)
        {
            shoesList.add((Shoes)givenArticle);
        }
        else if (givenArticle instanceof Outerwear)
        {
            outerwearList.add((Outerwear)givenArticle);
        }
        else if (givenArticle instanceof Accessories)
        {
            accessoriesList.add((Accessories)givenArticle);
        }
        else
        {
            System.out.println("ERROR: " + givenArticle.name + " is invalid");
        }

    }

    private boolean overOnePattern(Shirt givenShirt, Pants givenPants, 
        Shoes givenShoes)
    {
        return (givenShirt.isPatterned() && givenPants.isPatterned()) ||
            (givenShirt.isPatterned() && givenShoes.isPatterned()) ||
            (givenPants.isPatterned() && givenShoes.isPatterned());
    }

    private boolean mixCasualAndDress(Shirt givenShirt, Pants givenPants, 
    Shoes givenShoes, Accessories givenAccessories)
    {
        return (givenShirt.isCasual() || givenPants.isCasual() || 
            givenShoes.isCasual() || givenAccessories.isCasual()) &&
            (!givenShirt.isCasual() || !givenPants.isCasual() || 
            !givenShoes.isCasual() || !givenAccessories.isCasual());
    }

    private boolean mixSeasons(Shirt givenShirt, Pants givenPants, 
    Shoes givenShoes, Outerwear givenOuterwear)
    {
        return (givenShirt.isSummer() || givenPants.isSummer() || 
            givenShoes.isSummer() || givenOuterwear.isSummer()) &&
            (!givenShirt.isSummer() || !givenPants.isSummer() || 
            !givenShoes.isSummer() || !givenOuterwear.isSummer());
    }

    private boolean mixOrangeAndRed(Shirt givenShirt, Pants givenPants, 
    Shoes givenShoes, Outerwear givenOuterwear, Accessories givenAccessories)
    {
        return (givenShirt.color.equalsIgnoreCase("orange") || 
            givenPants.color.equalsIgnoreCase("orange") || 
            givenShoes.color.equalsIgnoreCase("orange") ||
            givenOuterwear.color.equalsIgnoreCase("orange") ||
            givenAccessories.color.equalsIgnoreCase("orange")) &&
            (givenShirt.color.equalsIgnoreCase("red") || 
            givenPants.color.equalsIgnoreCase("red") || 
            givenShoes.color.equalsIgnoreCase("red") ||
            givenOuterwear.color.equalsIgnoreCase("red") ||
            givenAccessories.color.equalsIgnoreCase("red"));
    }



    private boolean isGoodOutfit(Shirt givenShirt, Pants givenPants, 
        Shoes givenShoes, Outerwear givenOuterwear, Accessories givenAccessories)
    {
        System.out.println("Trying this outfit:");
        System.out.println(givenShirt + "\n" + givenPants + "\n" + 
            givenShoes + "\n" + givenOuterwear + "\n" + givenAccessories);
        
        boolean checkOverOnePattern = overOnePattern(givenShirt, givenPants, givenShoes);
        boolean checkMixCasualAndDress = mixCasualAndDress(givenShirt, givenPants, givenShoes, givenAccessories);
        boolean checkMixSeasons = mixSeasons(givenShirt, givenPants, givenShoes, givenOuterwear);
        boolean checkMixOrangeAndRed = mixOrangeAndRed(givenShirt, givenPants, givenShoes, givenOuterwear, givenAccessories);

        // if any of the above are true, it's not a good outfit
        boolean isGood = !(checkOverOnePattern || checkMixCasualAndDress || checkMixSeasons || checkMixOrangeAndRed);
        
        if (isGood)
        {
            System.out.println("This outfit is good!\n");
        }
        else
        {
            System.out.println("This outfit is bad!\n");
        }
        
        return isGood;
    }

    protected void generateOutfits()
    {
        Shirt currentShirt = null;
        Pants currentPants = null;
        Shoes currentShoes = null;
        Outerwear currentOuterwear = null;
        Accessories currentAccessories = null; 

        do
        {
            currentShirt = shirtsList.get(new Random().nextInt(shirtsList.size()));
            currentPants = pantsList.get(new Random().nextInt(pantsList.size()));
            currentShoes = shoesList.get(new Random().nextInt(shoesList.size()));
            currentOuterwear = outerwearList.get(new Random().nextInt(outerwearList.size()));
            currentAccessories = accessoriesList.get(new Random().nextInt(accessoriesList.size()));
        } 
        while (!isGoodOutfit(currentShirt, currentPants, currentShoes, currentOuterwear, currentAccessories));
    }

    //toString
    public String toString()
    {
        return name;
    }
}