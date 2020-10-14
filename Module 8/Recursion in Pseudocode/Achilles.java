public class Achilles
{
    public static int steps(float distance)
    {
        if (distance <= 0)
        {
            return 0;
        } 
        else if (distance <= 1)
        {
            return 1;
        }

        int count = steps(distance/2);
        if (distance > 1)
        { 
            count++;
        }
        return count;
    }

    public static void main(String args[]) 
    {
        System.out.println(steps(6)); //4
        System.out.println(steps(1)); //1
        System.out.println(steps(0)); //0
        System.out.println(steps(0.5f)); //1
        System.out.println(steps(8)); //4
        System.out.println(steps(10)); //5
    }
}