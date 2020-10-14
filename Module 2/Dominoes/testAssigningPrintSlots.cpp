#include <iostream>
using namespace std;

// Domino struct
struct domino {
    int topDots; 
    int bottomDots;
    //static const int numSlots = 21;
    //char printSlots[21] = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '-', '-', '-', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}; //creating static array in dynamic setting
};

//const int numSlots = 21;
//char printSlots[numSlots] = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '-', '-', '-', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

void printDomino(domino givenDomino) {
    const int numSlots = 21;
    char printSlots[numSlots] = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '-', '-', '-', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

    if (givenDomino.topDots >= 6) {
        printSlots[3] = '*';
        printSlots[5] = '*';
    }
    if (givenDomino.topDots >= 4) {
        printSlots[2] = '*';
        printSlots[6] = '*';
    }
    if (givenDomino.topDots >= 2) {
        printSlots[0] = '*';
        printSlots[8] = '*';
    }
    if (givenDomino.topDots%2 != 0) {
        printSlots[4] = '*';
    }
    if (givenDomino.bottomDots >= 6) {
        printSlots[15] = '*';
        printSlots[17] = '*';
    }
    if (givenDomino.bottomDots >= 4) {
        printSlots[14] = '*';
        printSlots[18] = '*';
    }
    if (givenDomino.bottomDots >= 2) {
        printSlots[12] = '*';
        printSlots[20] = '*';
    }
    if (givenDomino.bottomDots%2 != 0) {
        printSlots[16] = '*';
    }

    for (int i = 0; i < numSlots; i++) {
        cout << printSlots[i];
        if ((i+1)%3 == 0) {
            cout << "\n";
        }
    }
    cout << "\n\n";
}

/*void printDomino(domino givenDomino) {
    for (int i = 0; i < numSlots; i++) {
        cout << printSlots[i];
        if ((i+1)%3 == 0) {
            cout << "\n";
        }
    }
    cout << "\n\n";
}*/

int main() {
    // A double-six set has 28 dominoes total, with max 6 dots on the top & bottom
    const int ARRAY_SIZE = 28;
    const int maxDots = 6;
    
    domino doubleSixSet[ARRAY_SIZE]; 
    
    // Populate the array with all dominoes in a double-six set
    int currentDomino = 0;
    for (int i = 0; i <= maxDots; i++) {   
        for (int j = 0; j <= i; j++) {
            doubleSixSet[currentDomino].bottomDots = i;
            doubleSixSet[currentDomino].topDots = j;
            //cout << doubleSixSet[currentDomino].bottomDots << doubleSixSet[currentDomino].topDots << endl;
            //setupForPrinting(doubleSixSet[currentDomino]);
            currentDomino++;
        }
    }

    //dominoSort(doubleSixSet, ARRAY_SIZE);
    for (int i = 0; i < ARRAY_SIZE; i++) {
        //cout << doubleSixSet[i].bottomDots << doubleSixSet[i].topDots << endl;
        //printDomino(doubleSixSet[i]);
        printDomino(doubleSixSet[i]);
    }

    //printSetup(doubleSixSet[0]);

    /*currentDomino = 0;
    for (int i = 0; i < doubleSixSet[currentDomino].numSlots; i++) {
        cout << doubleSixSet[currentDomino].printSlots[i];
        if ((i+1)%3 == 0) {
            cout << "\n";
        }
    }*/
    
    return 0;
}