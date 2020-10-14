public class TestClass {

    public static void main(String[] args) {
        LegoHat sunVisor = new LegoHat("sun visor", 5);
        LegoHat toque = new LegoHat("toque", 6);
        LegoItem shield = new LegoItem("shield", 5);
        LegoItem sword = new LegoItem("sword", 10);

        // Test cases below, expected output in comments:
        
        LegoMinifigure testMinifigure = new LegoMinifigure("Emmet", null, null, null);

        System.out.println(testMinifigure.toString()); // A Lego minifigure named Emmet
        System.out.println(testMinifigure.isGood("winter", 11)); // false

        testMinifigure.placeInLeftHand(shield);
        System.out.println(testMinifigure.toString()); 
        // A Lego minifigure named Emmet, who is holding a 5.0-gram shield in the left hand

        testMinifigure.swapHands();
        System.out.println(testMinifigure.toString()); 
        // A Lego minifigure named Emmet, who is holding a 5.0-gram shield in the right hand

        testMinifigure.wearHat(sunVisor);
        testMinifigure.placeInRightHand(sword);
        System.out.println(testMinifigure.toString()); 
        // A Lego minifigure named Emmet, who is wearing a size 5 sun visor and holding a 
        // 10.0-gram sword in the right hand
        System.out.println(testMinifigure.isGood("winter", 11)); // false
        System.out.println(testMinifigure.isGood("summer", 11)); // true

        testMinifigure.wearHat(toque);
        testMinifigure.placeInLeftHand(shield);
        System.out.println(testMinifigure.toString());
        // A Lego minifigure named Emmet, who is wearing a size 6 toque and holding a 
        // 5.0-gram shield in the left hand and holding a 10.0-gram sword in the right hand

        System.out.println(testMinifigure.isGood("winter", 11)); // true
        System.out.println(testMinifigure.isGood("winter", 9.9f)); // false
        System.out.println(testMinifigure.isGood("fall", 11)); // false

        LegoMinifigure testMinifigure2 = new LegoMinifigure("Lucy", toque, shield, sword);
        
        System.out.println(testMinifigure2.toString());
        // A Lego minifigure named Lucy, who is wearing a size 6 toque and holding a 
        // 5.0-gram shield in the left hand and holding a 10.0-gram sword in the right hand
    }
}