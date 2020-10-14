#include <iostream>

using namespace std;

bool isSorted (int array[], int numItems) {
    int currentPosition = 1;

    while (currentPosition < numItems) {
        if (array[currentPosition] < array[currentPosition - 1]){
            return false;
        }
        currentPosition++;
    }
    return true;

    /*
    while ((currentPosition < numItems) && (array[currentPosition] > array[currentPosition - 1])) {
        currentPosition++;
    }
    if (currentPosition < numItems - 1) {
        return false;
    } else {
        return true;
    }
    */
}

int main()
{
    const int TEST_ARRAY_SIZE = 7;
    
    int testArray1[TEST_ARRAY_SIZE] = {4, 2, 4, 5, 6, 7, 8};
    cout << "isSorted returned " << isSorted(testArray1, TEST_ARRAY_SIZE) << "\n"; // should return 0 (false)

    int testArray2[TEST_ARRAY_SIZE] = {1, 2, 4, 5, 6, 7, 8};
    cout << "isSorted returned " << isSorted(testArray2, TEST_ARRAY_SIZE) << "\n"; // should return 1 (true)

    int testArray3[TEST_ARRAY_SIZE] = {1, 1, 1, 1, 1, 1, 1};
    cout << "isSorted returned " << isSorted(testArray3, TEST_ARRAY_SIZE) << "\n"; // should return 1 (true)

    return 0;
}