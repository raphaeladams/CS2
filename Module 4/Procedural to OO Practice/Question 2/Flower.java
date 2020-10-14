public class Flower {
    String color;
    int height;
    float percentWater;

    public Flower(String newColor, int newHeight, float newPercentWater) {
        color = newColor;
        height = newHeight;
        percentWater = newPercentWater;
    }

    public void print() {
        System.out.println(color + " (" + height + " cm, " + percentWater +  "% water)");
    }

    public void grow() {
        height += 2;
        percentWater -= 0.05f;
    }

    public void water() {
        percentWater += 0.1f;
    }

    public static void main(String[] args) {
        Flower f = new Flower("purple", 10, 0.5f);

        f.print();
        f.water();
        f.print();
        f.grow();
        f.print();
    }
}