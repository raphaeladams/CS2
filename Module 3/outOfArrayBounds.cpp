#include <iostream>
using namespace std;

char characterAt(char s[], int position) {
    return s[position];
}

int main() {
    char testArray[3] = {'0', '1', '2'};
    cout << characterAt(testArray, 2) << endl;
    return 0;
}