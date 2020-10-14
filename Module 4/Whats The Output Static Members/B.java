public class B
{
  private int value;
  public int count;
 
  public B(int v)
  {
    this.value = v;
    this.count = 0;
  }
 
  public int getValue()
  {
    count += 1;
    return value/2;
  }
 
  public int setValue(int v)
  {
    value = value + v;
    count +=2;
    return value;
  }

  public static void main(String[] args)
  {
    A.updateType("toothbrush");

    A a = new A(4);
    B b = new B(7);

    a.setValue(b.setValue(a.getValue()));
    int c = 2*a.count + 3*b.count;

    System.out.println(c + b.setValue(b.getValue()));
    System.out.println(a.type);
  }
}