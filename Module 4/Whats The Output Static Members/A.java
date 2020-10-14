public class A
{
  public int value;
  public int count;
 
  public static String type = "widget";
 
  public A(int v)
  {
    this.value = v;
    this.count = 0;
  }
 
  public int getValue()
  {
    count += 1;
    return value;
  }
 
  public int setValue(int v)
  {
    value = v*v;
    count += 2;
    return value;
  }
 
  public static void updateType(String newType)
  {
    type = newType;
  }
}