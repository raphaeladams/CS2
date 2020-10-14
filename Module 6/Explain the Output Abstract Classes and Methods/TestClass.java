public class TestClass
{
    public static void main(String args[])
    {
        //A a = new A();
        B b = new B();
        C c = new C();

        //a.one();
        //a.two();
        //a.three();
        //a.three(1);
        b.one();
        b.two();
        b.three();
        b.three(1);
        b.three("Hello");
        c.one();
        c.two();
        c.three();
        c.three(1);
        c.three("Hello");
    }
}