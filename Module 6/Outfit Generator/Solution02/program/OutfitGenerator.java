package program;

import clothing.*;
import clothing.types.*;

import java.util.ArrayList;
import java.util.Random;

public class OutfitGenerator
{
    //attributes
    private static ArrayList<Shirt> shirtsList = new ArrayList<Shirt>();
    private static ArrayList<Pants> pantsList = new ArrayList<Pants>();
    private static ArrayList<Shoes> shoesList = new ArrayList<Shoes>();
    private static ArrayList<Outerwear> outerwearList = new ArrayList<Outerwear>();
    private static ArrayList<Accessories> accessoriesList = new ArrayList<Accessories>();
    
    //constructors
    private OutfitGenerator()
    {
        // make the class non-instantiable
    }
    
    //other methods
    public static void add(Clothing givenArticle)
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
        // assuming no "else" case required (internal testing)
    }

    private static boolean overOnePattern(Shirt givenShirt, Pants givenPants, 
        Shoes givenShoes)
    {
        return (givenShirt.isPatterned() && givenPants.isPatterned()) ||
            (givenShirt.isPatterned() && givenShoes.isPatterned()) ||
            (givenPants.isPatterned() && givenShoes.isPatterned());
    }

    private static boolean mixCasualAndDress(Shirt givenShirt, Pants givenPants, 
    Shoes givenShoes, Accessories givenAccessories)
    {
        return (givenShirt.isCasual() || givenPants.isCasual() || 
            givenShoes.isCasual() || givenAccessories.isCasual()) &&
            (!givenShirt.isCasual() || !givenPants.isCasual() || 
            !givenShoes.isCasual() || !givenAccessories.isCasual());
    }

    private static boolean mixSeasons(Shirt givenShirt, Pants givenPants, 
    Shoes givenShoes, Outerwear givenOuterwear)
    {
        return (givenShirt.isSummer() || givenPants.isSummer() || 
            givenShoes.isSummer() || givenOuterwear.isSummer()) &&
            (!givenShirt.isSummer() || !givenPants.isSummer() || 
            !givenShoes.isSummer() || !givenOuterwear.isSummer());
    }

    private static boolean mixOrangeAndRed(Shirt givenShirt, Pants givenPants, 
    Shoes givenShoes, Outerwear givenOuterwear, Accessories givenAccessories)
    {
        return (givenShirt.getColor().equalsIgnoreCase("orange") || 
            givenPants.getColor().equalsIgnoreCase("orange") || 
            givenShoes.getColor().equalsIgnoreCase("orange") ||
            givenOuterwear.getColor().equalsIgnoreCase("orange") ||
            givenAccessories.getColor().equalsIgnoreCase("orange")) &&
            (givenShirt.getColor().equalsIgnoreCase("red") || 
            givenPants.getColor().equalsIgnoreCase("red") || 
            givenShoes.getColor().equalsIgnoreCase("red") ||
            givenOuterwear.getColor().equalsIgnoreCase("red") ||
            givenAccessories.getColor().equalsIgnoreCase("red"));
    }

    private static boolean isGoodOutfit(Shirt givenShirt, Pants givenPants, 
        Shoes givenShoes, Outerwear givenOuterwear, Accessories givenAccessories)
    {
        System.out.println("Trying this outfit:");
        System.out.println(givenShirt + "\n" + givenPants + "\n" + 
            givenShoes + "\n" + givenOuterwear + "\n" + givenAccessories);
        
        boolean checkOverOnePattern = 
            overOnePattern(givenShirt, givenPants, givenShoes);
        boolean checkMixCasualAndDress = 
            mixCasualAndDress(givenShirt, givenPants, givenShoes, givenAccessories);
        boolean checkMixSeasons = 
            mixSeasons(givenShirt, givenPants, givenShoes, givenOuterwear);
        boolean checkMixOrangeAndRed = 
            mixOrangeAndRed(givenShirt, givenPants, givenShoes, givenOuterwear, givenAccessories);

        // if any of the above are true, it's not a good outfit
        boolean isGood = 
            !(checkOverOnePattern || checkMixCasualAndDress || 
            checkMixSeasons || checkMixOrangeAndRed);
        
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

    public static void generateOutfits()
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
        while (!isGoodOutfit(currentShirt, currentPants, 
            currentShoes, currentOuterwear, currentAccessories));
    }
}