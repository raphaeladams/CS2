#include <iostream>
using namespace std;

// Domino struct
struct domino {
    int topDots; // number of dots on top half of domino
    int bottomDots; // number of dots on bottom half
};

// This function sorts dominoes like this: https://screenshot.click/20-08-25fmx-a6fbk.png,
// using insertion sort.
void sortDominoes(domino setOfDominoes[], int numDominoes) {
    int i = 1;
    int j = i;
    while (i < numDominoes) {
        bool pastFirstDomino = (j > 0);
        bool lessTopDotsThanPrevious = (setOfDominoes[j].topDots < setOfDominoes[j-1].topDots);
        bool sameTopDotsAsPrevious = (setOfDominoes[j].topDots == setOfDominoes[j-1].topDots);
        bool lessBottomDotsThanPrevious = (setOfDominoes[j].bottomDots < setOfDominoes[j-1].bottomDots);
        
        // compare this domino to the previous one(s), swap until it's in correct position
        if (pastFirstDomino && 
            (lessTopDotsThanPrevious ||
            (sameTopDotsAsPrevious && lessBottomDotsThanPrevious))) {

            domino swap = setOfDominoes[j];
            setOfDominoes[j] = setOfDominoes[j-1];
            setOfDominoes[j-1] = swap;
            j--; 
        } else {
            i++;
            j = i; // if this domino is in correct position, move on to next unsorted one
        }
    }
}

// This function prints a domino. 21 characters will be needed in total.
// Each domino half contains 3x3 characters, which will contain either ' ' or '*'
// depending on the number of dots in the half. For example, this would be a 5: 
// * *
//  * 
// * *
// There are 3 additional characters in the middle containing '-', separating the halves.
void printDomino(domino givenDomino) {
    const int numChars = 21;
    char dominoChars[numChars] = {
        ' ', ' ', ' ', 
        ' ', ' ', ' ', 
        ' ', ' ', ' ', 
        '-', '-', '-', 
        ' ', ' ', ' ', 
        ' ', ' ', ' ', 
        ' ', ' ', ' '
    };

    // Change appropriate characters to asterisks.
    if (givenDomino.topDots >= 6) {
        dominoChars[3] = '*';
        dominoChars[5] = '*'; 
    } else if (givenDomino.topDots%2 != 0) {
        dominoChars[4] = '*'; 
    }
    
    if (givenDomino.topDots >= 4) {
        dominoChars[2] = '*';
        dominoChars[6] = '*'; 
    }
    if (givenDomino.topDots >= 2) {
        dominoChars[0] = '*';
        dominoChars[8] = '*'; 
    }
    
    if (givenDomino.bottomDots >= 6) {
        dominoChars[15] = '*';
        dominoChars[17] = '*'; 
    } else if (givenDomino.bottomDots%2 != 0) {
        dominoChars[16] = '*'; 
    }
    
    if (givenDomino.bottomDots >= 4) {
        dominoChars[14] = '*';
        dominoChars[18] = '*'; 
    }
    if (givenDomino.bottomDots >= 2) {
        dominoChars[12] = '*';
        dominoChars[20] = '*'; 
    }
    
    // Print out domino characters, going to new line when appropriate
    for (int i = 0; i < numChars; i++) {
        cout << dominoChars[i];
        if ((i+1)%3 == 0) {
            cout << "\n";
        }
    }
    cout << "\n\n";
}

int main() {
    // A double-six set has 28 dominoes total, max 6 dots on top & bottom
    const int ARRAY_SIZE = 28;
    const int maxDots = 6;
    
    // Create array with all dominoes in a double-six set
    domino doubleSixSet[ARRAY_SIZE];

    int currentDomino = 0;
    for (int i = 0; i <= maxDots; i++) {   
        for (int j = 0; j <= i; j++) {
            doubleSixSet[currentDomino].bottomDots = i;
            doubleSixSet[currentDomino].topDots = j;
            currentDomino++;
        }
    }

    sortDominoes(doubleSixSet, ARRAY_SIZE);

    for (int i = 0; i < ARRAY_SIZE; i++) {
        printDomino(doubleSixSet[i]);
    }

    return 0;
}