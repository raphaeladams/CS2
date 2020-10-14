public class LegoHat {
    public String style;
    public int size;

    public LegoHat(String newStyle, int newSize) {
        this.style = newStyle;
        this.size = newSize;
    }

    public String toString() {
        return "a size " + this.size + " " + this.style;
    }

    public int computeStyle(String season) {
        if (this.style.equals("toque") && !season.equals("winter")) {
            return 1;
        } else if (this.style.equals("sun visor") && !season.equals("summer")) {
            return 1;
        } else {
            return 10;
        }
    }
}