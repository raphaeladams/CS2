public class TestClass
{
    public static int factorial2(int n)
    {
        if (n <= 1)
        {
            return 1;
        }
        return n * factorial2(n - 2);
    }

    public static int fib(int n)
    {
        if (n <= 0)
        {
            return 0;
        }
        else if ( n == 1)
        {
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public static void main(String args[]) 
    {
        System.out.println("\nTESTING DOUBLE FACTORIAL");
        System.out.println(factorial2(4)); //8
        System.out.println(factorial2(5)); //15
        System.out.println(factorial2(6)); //48
        System.out.println(factorial2(1)); //1
        System.out.println(factorial2(-1)); //1
        System.out.println(factorial2(0)); //1
        System.out.println(factorial2(7)); //105



        //////////////////////



        System.out.println("\nTESTING FIBONACCI");
        System.out.println(fib(0)); //0
        System.out.println(fib(1)); //1
        System.out.println(fib(2)); //1
        System.out.println(fib(3)); //2
        System.out.println(fib(4)); //3
        System.out.println(fib(5)); //5
        System.out.println(fib(6)); //8
        System.out.println(fib(7)); //13
        System.out.println(fib(8)); //21
        System.out.println(fib(-1)); //0
    }
}