#include <iostream>

using namespace std;

int main(int argc, char** argv) {
    cout << "enter a character: ";
    char digit;
    do {
        digit = cin.get();
        cout << int(digit) << " ";
    } while (digit != 10);
    
    return 0;
}