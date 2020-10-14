#include <iostream>

using namespace std;

int main(int argc, char** argv) {
    char enteredChar;
    int mostVowels = 0;
    int currentVowels = 0;

    cout << "Enter text: ";

    do {
        enteredChar = cin.get();

        switch (enteredChar) {
            /*case 'a': case 'e': case 'i': case 'o': case 'u':
            case 'A': case 'E': case 'I': case 'O': case 'U':
                currentVowels++;*/
            case 'a'...'z': case 'A'...'Z':
                switch (enteredChar) {
                    case 'a': case 'e': case 'i': case 'o': case 'u':
                    case 'A': case 'E': case 'I': case 'O': case 'U':
                        currentVowels++;
                        break;
                }
                break;
            default:
                if (currentVowels > mostVowels) {
                    mostVowels = currentVowels;
                }
                currentVowels = 0;
                break;
        }

        /*if ((enteredChar >= 'a' && enteredChar <= 'z') || (enteredChar >= 'A' && enteredChar <= 'Z')) {
            switch (enteredChar) {
                case 'a': case 'e': case 'i': case 'o': case 'u':
                case 'A': case 'E': case 'I': case 'O': case 'U':
                    currentVowels++;
                    break;
            }
        } else {
            if (currentVowels > mostVowels) {
                mostVowels = currentVowels;
            }
            currentVowels = 0;
        }*/

    } while (enteredChar != 10);

    cout << "Largest number of vowels in a word was " << mostVowels << "\n";
    return 0;
}