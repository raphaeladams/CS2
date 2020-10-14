// Test class to hold the functions, including main()

public class TestScotchTape {

    public static void printTapeArray(ScotchTape[] tapeArray) {
        for (int i = 0; i < tapeArray.length; i++) {
            System.out.println(tapeArray[i].colour + " (" +
                tapeArray[i].length + " cm, " +
                tapeArray[i].weight + " oz)");
        }
    }

    public static void stickTape(ScotchTape tape, float percentToUse) {
        tape.weight -= (int)(tape.weight * percentToUse);
        tape.length -= (int)(tape.length * percentToUse);
    }

    public static void main(String[] args) {
        ScotchTape tapes[] = new ScotchTape[3];

        tapes[0] = new ScotchTape();
        tapes[0].colour = "clear";
        tapes[0].weight = 3;
        tapes[0].length = 22;

        tapes[1] = new ScotchTape();
        tapes[1].colour = "green";
        tapes[1].weight = 1;
        tapes[1].length = 15;

        tapes[2] = new ScotchTape();
        tapes[2].colour = "blue";
        tapes[2].weight = 2;
        tapes[2].length = 19;

        printTapeArray(tapes);

        stickTape(tapes[0], 0.5f);
        stickTape(tapes[1], 0.3f);
        stickTape(tapes[2], 0.9f);

        System.out.println();

        printTapeArray(tapes);
    }
}