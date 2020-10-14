#include <iostream>

using namespace std;

// This function takes an array of new characters and attempts to insert them in an existing char array.
// Starting at the beginning of the given array, it loops through until it finds a slot with the value 0, 
// and overwrites it with the next new character. 
// This is repeated until we're out of new characters, or we've reached the end of the given array.
void addData(char charsToAdd[], int numCharsToAdd, char givenArray[], int numItems) {
    int positionInCharsToAdd = 0;
    int positionInGivenArray = 0;
    while (positionInCharsToAdd < numCharsToAdd && positionInGivenArray < numItems) {
        while (givenArray[positionInGivenArray] != 0) {
            positionInGivenArray++;
        }
        givenArray[positionInGivenArray] = charsToAdd[positionInCharsToAdd];
        positionInCharsToAdd++;
    }
}

// This function takes an array of indexes/positions to remove characters in an existing char array.
// As long as the position is within the bounds of the char array, the value at that position
// will be changed to 0 and considered "empty".
void removeData(int charRemovalPositions[], int numRemovalPositions, char givenArray[], int numItems) {
    for (int i = 0; i < numRemovalPositions; i++) {
        if (charRemovalPositions[i] >= 0 && charRemovalPositions[i] < numItems) {
            givenArray[charRemovalPositions[i]] = 0;
        } else {
            cout << "Error removing data, our array doesn't have a position " << charRemovalPositions[i] << "!\n";
        }
    }
}

int main()
{
    const int ARRAY_SIZE = 50;   
    char testArray1[ARRAY_SIZE] = {};

    //int numCharsToAddTest = 10;
    char charsToAdd[10] = {'b', 'c', 'd', 'j', '&', 'e', '7', 'm', 'P', '1'};
    //int numRemovalPositions = 2;
    int charRemovalPositions[2] = {1, 8};

    addData(charsToAdd, 10, testArray1, ARRAY_SIZE);
    removeData(charRemovalPositions, 2, testArray1, ARRAY_SIZE);
    
    for (int i = 0; i < ARRAY_SIZE; i++) {
        cout << testArray1[i] << endl;
    }
    
    return 0;
}