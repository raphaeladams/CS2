public class LegoItem {
    public String name;
    public float weight;

    public LegoItem(String newName, float newWeight) {
        this.name = newName;
        this.weight = newWeight;
    }

    public String toString() {
        return "a " + this.weight + "-gram " + this.name;
    }

    public boolean isHeavy(float threshold) {
        return (this.weight > threshold);
    }
}