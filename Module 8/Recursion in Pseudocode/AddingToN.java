public class AddingToN
{
    public static int addIntegers(int n)
    {
        if (n <= 1)
        {
            return 1;
        }

        int lastNum = n;
        int sumOfAllButLast = addIntegers(n-1);
        return sumOfAllButLast + lastNum;
    }

    public static void main(String args[]) 
    {
        System.out.println(addIntegers(1)); //1
        System.out.println(addIntegers(0)); //1
        System.out.println(addIntegers(2)); //3
        System.out.println(addIntegers(3)); //6
        System.out.println(addIntegers(4)); //10
    }
}