package program;

import clothing.types.*;
import clothing.types.subclasses.*;

public class TestClass
{
    public static void main(String args[])
    {
        Shirt testTShirt = new Tshirt("Joe's T-shirt", "red");
        Shirt testDressShirt = new DressShirt("Joe's dress shirt", "white");
        Shirt testHawaiianShirt = new HawaiianShirt("Joe's Hawaiian shirt", "blue");
        Shirt testVest = new Vest("Joe's vest", "black");

        Pants testJeans = new Jeans("Joe's jeans", "blue");
        Pants testDressPants = new DressPants("Joe's dress pants", "black");
        Pants testBoardShorts = new BoardShorts("Joe's board shorts", "pink");
        Pants testKhakis = new Khakis("Joe's khakis", "tan");

        Shoes testSandals = new Sandals("Joe's sandals", "brown");
        Shoes testDressShoes = new DressShoes("Joe's dress shoes", "black");
        Shoes testNikes = new Nikes("Joe's Nikes", "white");
        Shoes testBoatShoes = new BoatShoes("Joe's boat shoes", "orange");

        Outerwear testSpringCoat = new SpringCoat("Joe's spring coat", "blue");
        Outerwear testWinterJacket = new WinterJacket("Joe's winter jacket", "green");
        Outerwear testRaincoat = new Raincoat("Joe's raincoat", "red");
        Outerwear testParka = new Parka("Joe's parka", "black");

        Accessories testEarrings = new Earrings("Joe's earrings", "gold");
        Accessories testTie = new Tie("Joe's tie", "red");
        Accessories testWatch = new Watch("Joe's watch", "gold");
        Accessories testCummerbund = new Cummerbund("Joe's cummerbund", "red");

        
        OutfitGenerator.add(testTShirt);
        OutfitGenerator.add(testDressShirt);
        OutfitGenerator.add(testHawaiianShirt);
        OutfitGenerator.add(testVest);
        OutfitGenerator.add(testJeans);
        OutfitGenerator.add(testDressPants);
        OutfitGenerator.add(testBoardShorts);
        OutfitGenerator.add(testKhakis);
        OutfitGenerator.add(testSandals);
        OutfitGenerator.add(testDressShoes);
        OutfitGenerator.add(testNikes);
        OutfitGenerator.add(testBoatShoes);
        OutfitGenerator.add(testSpringCoat);
        OutfitGenerator.add(testWinterJacket);
        OutfitGenerator.add(testRaincoat);
        OutfitGenerator.add(testParka);
        OutfitGenerator.add(testEarrings);
        OutfitGenerator.add(testTie);
        OutfitGenerator.add(testWatch);
        OutfitGenerator.add(testCummerbund);


        OutfitGenerator.generateOutfits();
        // Outfits should generate and print until a combination is successful.
    }
}