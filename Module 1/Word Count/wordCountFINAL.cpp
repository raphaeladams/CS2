#include <iostream>

using namespace std;

int main(int argc, char** argv) {
    char enteredChar; //will hold the current character the user enters
    
    //"tracking" variables to store info about the entered characters:
    bool writingAWord = false;
    bool loneDashOrApostrophe = false;
    int numWords = 0;
    int longestWordLength = 0;
    int currentWordLength = 0;
    int mostVowels = 0;
    int currentVowels = 0;

    cout << "Enter text: ";

    do {
        enteredChar = cin.get(); //read characters in one at a time

        switch (enteredChar) {
            
            /* Dashes and apostrophes can be included in words. Assume they count towards a word's length.
             * If the user has typed a dash or apostrophe immediately after something that isn't a word, we don't yet know 
             * whether it will be included in the next word. For now we assume yes, so we increase numWords. 
             * We also set loneDashOrApostrophe = true to keep track. It will stay true until any other character is entered. */
            case '\'': case '-':
                if (!writingAWord) {
                    loneDashOrApostrophe = true;
                    numWords++; //begin a new word if we're not already in the middle of one
                }
                writingAWord = true;
                currentWordLength++;
                break;

            /* If user has typed a letter (caps/lowercase), number, or underscore:
             * (Underscores on their own count as "words" in Google Docs) */
            case 'a'...'z': case 'A'...'Z': case '0'...'9': case '_':
                if (!writingAWord) {
                    numWords++; 
                }
                writingAWord = true;
                loneDashOrApostrophe = false;
                currentWordLength++;
                
                //If that character is a vowel:
                switch (enteredChar) {
                    case 'a': case 'e': case 'i': case 'o': case 'u':
                    case 'A': case 'E': case 'I': case 'O': case 'U':
                        currentVowels++;
                        break;
                }
                break;

            //If user has typed anything other than the above:
            default:
                if (loneDashOrApostrophe) {
                    numWords--; //the lone dash/apostrophe(s) weren't part of a word after all
                } else if (currentWordLength > longestWordLength) {
                    longestWordLength = currentWordLength;
                }

                if (currentVowels > mostVowels) {
                    mostVowels = currentVowels;
                }

                //reset "tracking" variables for the next word
                writingAWord = false;
                loneDashOrApostrophe = false;
                currentWordLength = 0;
                currentVowels = 0;
                break;
        }

    } while (enteredChar != 10); //stop reading characters when user hits Enter

    //Output data:
    cout << "Number of words: " << numWords << "\n";
    cout << "Longest word was " << longestWordLength << " characters long.\n";
    cout << "Largest number of vowels in a word was " << mostVowels << "\n";
    return 0;
}