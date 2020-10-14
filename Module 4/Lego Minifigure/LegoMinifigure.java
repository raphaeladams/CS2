public class LegoMinifigure {
    public String name;
    public LegoHat hat;
    public LegoItem leftHandItem;
    public LegoItem rightHandItem;

    public LegoMinifigure(String newName, LegoHat newHat, LegoItem newLeftHandItem, LegoItem newRightHandItem) {
        // Assume null will be passed when constructing a minifigure without a hat and/or items
        // Assume a valid String will always be passed for name
        this.name = newName;
        this.hat = newHat;
        this.leftHandItem = newLeftHandItem;
        this.rightHandItem = newRightHandItem;
    }

    public String toString() {
        String minifigureDescription = "A Lego minifigure named " + this.name;

        if (this.hat != null) {
            minifigureDescription += ", who is wearing " + this.hat.toString();
            if (this.leftHandItem != null) {
                minifigureDescription += " and holding " + this.leftHandItem.toString() + " in the left hand";
            }
            if (this.rightHandItem != null) {
                minifigureDescription += " and holding " + this.rightHandItem.toString() + " in the right hand";
            }
        } else if (this.leftHandItem != null) {
            minifigureDescription += ", who is holding " + this.leftHandItem.toString() + " in the left hand";
            if (this.rightHandItem != null) {
                minifigureDescription += " and holding " + this.rightHandItem.toString() + " in the right hand";
            }
        } else if (this.rightHandItem != null) {
            minifigureDescription += ", who is holding " + this.rightHandItem.toString() + " in the right hand";
        }

        return minifigureDescription;
    }

    public void swapHands() {
        LegoItem swap = this.leftHandItem;
        this.leftHandItem = this.rightHandItem;
        this.rightHandItem = swap;
    }

    public void wearHat(LegoHat hat) {
        this.hat = hat;
    }

    public void placeInLeftHand(LegoItem item) {
        this.leftHandItem = item;
    }

    public void placeInRightHand(LegoItem item) {
        this.rightHandItem = item;
    }

    public boolean isGood(String season, float threshold) {
        // Returns true if the Lego minifigure is good. 
        // A minifigure is good if it is wearing a hat with style 
        // at least 6, and if it is not holding something heavy 
        // (this could mean, for example, that it is holding nothing in its hands)
        return (this.hat != null && this.hat.computeStyle(season) >= 6 && 
            (this.leftHandItem == null || !this.leftHandItem.isHeavy(threshold)) && 
            (this.rightHandItem == null || !this.rightHandItem.isHeavy(threshold)));
    }
}