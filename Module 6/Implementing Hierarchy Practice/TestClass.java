public class TestClass
{
    public static void main(String args[])
    {
        Fish genericFish = new Fish();
        genericFish.swim(); // Swimming

        Clownfish marlin = new Clownfish();
        marlin.swim(); // Swimming
        marlin.hide(); // Hiding in an anemone
        //marlin.getLost(); // Compiler error; this method only belongs to BabyClownfish

        BabyClownfish nemo = new BabyClownfish();
        nemo.swim(); // Swimming with Lucky Fin
        nemo.hide(); // Hiding in an anemone
        nemo.getLost(); // I'm lost!

        RoyalBlueTang dory = new RoyalBlueTang();
        dory.swim(); // Just keep swimming, just keep swimming
        //dory.hide(); // Compiler error; this method is protected (Clownfish only)
    }
}