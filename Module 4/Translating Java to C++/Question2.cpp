#include <iostream>
using namespace std;

float getAverageScore(int scoreArray[], int arrayLength) {
    float total = 0;
    for (int i = 0; i < arrayLength; i++) {
        total += scoreArray[i];
    }
    return (float)(total / arrayLength);
}

int main() {
    const int ARRAY_SIZE = 10;
    int scores[ARRAY_SIZE] = {}; // set these to 0 so we don't use garbage values later

    for (int i = 0; i < ARRAY_SIZE; i += 2) {
        scores[i] = i;
    }

    cout << "Average score: " << getAverageScore(scores, ARRAY_SIZE) << endl;

    return 0;
}