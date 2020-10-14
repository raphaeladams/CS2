#include <iostream>

using namespace std;

int main(int argc, char** argv) {
    char enteredChar;
    int longestWordLength = 0;
    int currentWordLength = 0;

    cout << "Enter text: ";

    do {
        enteredChar = cin.get();

        switch (enteredChar) {
            case 'a'...'z': case 'A'...'Z':
                currentWordLength++;
                break;
            default:
                if (currentWordLength > longestWordLength) {
                    longestWordLength = currentWordLength;
                }
                currentWordLength = 0;
                break;
        }

        /*if ((enteredChar >= 'a' && enteredChar <= 'z') || (enteredChar >= 'A' && enteredChar <= 'Z')) {
            currentWordLength++;
        } else {
            if (currentWordLength > longestWordLength) {
                longestWordLength = currentWordLength;
            }
            currentWordLength = 0;
        }*/

    } while (enteredChar != 10);

    cout << "Longest word was " << longestWordLength << " characters long.\n";
    return 0;
}