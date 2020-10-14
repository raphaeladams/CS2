#include <iostream>
#include <string.h>

using namespace std;


class flower {
public:
    string color;
    int height;
    float percentWater;

    flower(string newColor, int newHeight, float newPercentWater) {
        color = newColor;
        height = newHeight;
        percentWater = newPercentWater;
    }

    void print() {
        cout << color << " (" << height << " cm, "
        << percentWater << "% water)" << endl;
    }

    void grow() {
        height += 2;
        percentWater -= 0.05f;
    }

    void water() {
        percentWater += 0.1f;
    }
};

int main() {
    flower f("purple", 10, 0.5f);

    f.print();
    f.water();
    f.print();
    f.grow();
    f.print();
    
    return 0;
}