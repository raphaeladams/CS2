#include <iostream>
using namespace std;

// The struct -- I couldn't name it "time"; that name is taken in C++
struct aTime {
    // For our purposes, assume amOrPm, hour, minute, and second are given reasonable values 
    // ("AM" or "PM", 00:00:00 to 12:59:59).
    string amOrPm; 
    int hour; 
    int minute;
    int second;
};

// 1. Function taking a reference to the aTime struct as a parameter
void oneHourAhead(aTime &timeToChange) {   
    if (timeToChange.hour == 11 && timeToChange.amOrPm == "PM") {
        timeToChange.amOrPm = "AM";
        timeToChange.hour++;
    } else if (timeToChange.hour == 11) {
        timeToChange.amOrPm = "PM";
        timeToChange.hour++;
    } else if (timeToChange.hour == 12) {
        timeToChange.hour = 1;
    } else {
        timeToChange.hour++;
    }
}

// 2. "Black box" function that takes aTime struct passed by value
int secondsPastMidnight(aTime givenTime) {
    int total = (3600*givenTime.hour) + (60*givenTime.minute) + givenTime.second;
    if (givenTime.amOrPm == "PM" && givenTime.hour < 12) {
        total += 43200;
    } else if (givenTime.amOrPm == "AM" && givenTime.hour == 12) {
        total -= 43200;
    }
    return total;
}

// Just a quick function to output the time in correct format
void displayTime(aTime givenTime) {
    cout << givenTime.hour << ":" << givenTime.minute << ":";
    if (givenTime.second < 10) {
        cout << "0";
    }
    cout << givenTime.second << " " << givenTime.amOrPm << "\n";
}

int main() {
    aTime timeOfDay = {"AM", 11, 30, 8};
    cout << "Given time: ";
    displayTime(timeOfDay);

    oneHourAhead(timeOfDay);
    cout << "One hour ahead: ";
    displayTime(timeOfDay);

    cout << "After going one hour ahead, you are " << secondsPastMidnight(timeOfDay) << " seconds past midnight.\n";
    return 0;
}