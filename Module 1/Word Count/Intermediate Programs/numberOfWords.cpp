#include <iostream>

using namespace std;

int main(int argc, char** argv) {
    char enteredChar;
    int numWords = 0;
    bool writingAWord = false;

    cout << "Enter text: ";

    do {
        enteredChar = cin.get();

        switch (enteredChar) {
            case 'a'...'z': case 'A'...'Z':
                if (!writingAWord) {
                    numWords++;
                }
                writingAWord = true;
                break;
            default:
                writingAWord = false;
                break;
        }

        /*if ((enteredChar >= 'a' && enteredChar <= 'z') || (enteredChar >= 'A' && enteredChar <= 'Z')) {
            if (!writingAWord) {
                numWords++;
            }
            writingAWord = true;
        } else {
            writingAWord = false;
        }*/

    } while (enteredChar != 10);

    cout << "Number of words: " << numWords << "\n";
    return 0;
}