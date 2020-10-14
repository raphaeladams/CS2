public class TestClass
{
    public static void main(String args[])
    {
        A a = new A(); a.print(); // I'm an A
        B b = new B(); b.print(); // I'm a B
        C c = new C(); c.print(); // I'm a C
        D d = new D(); d.print(); // I'm a D
        A ab = new B(); ab.print(); // I'm a B
        A ac = new C(); ac.print(); // I'm a C
        A ad = new D(); ad.print(); // I'm a D
        B ba = new A(); ba.print(); // invalid, you can't take a new A object and assign it to a B variable because B is a subclass of A
        B bc = new C(); bc.print(); // I'm a C
        B bd = new D(); bd.print(); // I'm a D
        C ca = new A(); ca.print(); // invalid, you can't take a new A object and assign it to a C variable because C is a subclass of A
        C cb = new B(); cb.print(); // invalid, you can't take a new B object and assign it to a C variable because C is a subclass of B
        C cd = new D(); cd.print(); // invalid, you can't take a new D object and assign it to a C variable because C and D are two different subclasses of B
    }
}