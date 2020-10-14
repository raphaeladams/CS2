#include <iostream>

using namespace std;

int main()
{
    const int ARRAY_SIZE = 10;
    const char fixedArray[ARRAY_SIZE] = {'A', 'B', 'x', 'j', 'Z', 'Y', 'g', '!', '0', 'j'};
    int numUppercase = 0;

    for (int i = 0; i < ARRAY_SIZE; i++) {
        if (fixedArray[i] >= 'A' && fixedArray[i] <= 'Z') {
            numUppercase++;
        }
    }

    cout << "There are " << numUppercase << " uppercase characters in this array\n"; // should be 4
    return 0;
}