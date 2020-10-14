#include <iostream>
#include <iomanip>

using namespace std;

/* calculateDogYears is our "black box" function. You don't need to know that 1 human year is roughly 7 
 * dog years when you use it. You can just plug in the human's age without worrying about
 * the calculation, and the function will return the corresponding dog age. 
 * Note that a "dog year" isn't actually 7 human years, I'm using the stereotypical calculation :) */

float calculateDogYears(int yourAge)
{
    // Convert yourAge to a float before calculating, to avoid integer division
    float dogAge = (float)yourAge / 7.0; 
    return dogAge;
}

int main()
{
    // Set to print with 1 decimal place
    std::cout << std::fixed;
    std::cout << std::setprecision(1);

    // Tests! 
    cout << "7 human years is about " << calculateDogYears(7) << " dog years.\n";
    cout << "18 human years is about " << calculateDogYears(18) << " dog years. \n";
    cout << "100 human years is about " << calculateDogYears(100) << " dog years. \n";

    // Final test: Manual input
    int givenHumanAge = 0; // initialize with value 0
    
    cout << "If you're a human, enter your age in years: \t";
    cin >> givenHumanAge;
    cout << "You are about " << calculateDogYears(givenHumanAge) << " in dog years.\n";

    return 0;
}