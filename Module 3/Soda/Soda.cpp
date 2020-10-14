#include <iostream>
using namespace std;

struct soda {
    int gramsOfSugar;
    float gramsOfCarbonation;
};

int main() {
    int ARRAY_SIZE = 3;
    soda **sodaArray = new soda*[ARRAY_SIZE];

    // Create and store three dynamically allocated soda structs.
    sodaArray[0] = new soda;
    sodaArray[0]->gramsOfSugar = 2;
    sodaArray[0]->gramsOfCarbonation = 4;

    sodaArray[1] = new soda;
    sodaArray[1]->gramsOfSugar = 30;
    sodaArray[1]->gramsOfCarbonation = 35;

    sodaArray[2] = new soda;
    sodaArray[2]->gramsOfSugar = 100;
    sodaArray[2]->gramsOfCarbonation = 100;

    // Loop through array, print out values inside structs.
    for (int i = 0; i < ARRAY_SIZE; i++) {
        cout << "Soda " << i << " has:\n" 
            << sodaArray[i]->gramsOfSugar << "g sugar\n"
            << sodaArray[i]->gramsOfCarbonation << "g carbonation\n\n";
    }
    // Clean up memory ensuring one delete for every new.
    for (int i = 0; i < ARRAY_SIZE; i++) {
        delete sodaArray[i];
    }
    delete [] sodaArray;

    return 0;
}