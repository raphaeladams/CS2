#include <iostream>
#include <string>
#include <sstream>
using namespace std;

struct song {
    string title;
    string artist; 
    int year;
};

// Function to combine song details into one string
string songToString(song s) {
    std::stringstream ss; // use stringstream to convert s.year (an int) to string
    ss << s.year;
    string yearString = ss.str();
    return s.artist + " - " + s.title + " (" + yearString + ")\n";
}

// Function to return dynamically allocated array with all songs in given array from given year
song** songsFromYear(song **songs, int size, int year, int* resultSize) {
    *resultSize = 0;
    for (int i = 0; i < size; i++) {
        if (songs[i]->year == year) {
            *resultSize += 1;
        }
    }

    int position = 0;
    song **songsFromGivenYear = new song*[*resultSize];
    for (int i = 0; i < size; i++) {
        if (songs[i]->year == year) {
            songsFromGivenYear[position] = songs[i]; //point to same memory address
            position++;
        }
    }
    return songsFromGivenYear;
}

// Function to test songsFromYear function, given a year, in main()
void testSongsFromYear(song **songs, int size, int year) {
    std::stringstream ss; // use stringstream to convert given year (an int) to string
    ss << year;
    string yearString = ss.str();

    int *resultSize = new int;
    song **songsFromGivenYear = songsFromYear(songs, size, year, resultSize);

    if (*resultSize > 0) {
        cout << "Songs from " << yearString << ":\n";
        for (int i = 0; i < *resultSize; i++) {
            cout << songToString(*songsFromGivenYear[i]);
        }
    } else {
        cout << "No songs from " << yearString << "\n";
    }
    cout << "\n";

    // Clean up memory but don't call delete on elements in the array, 
    // they point to data we may still need elsewhere
    delete [] songsFromGivenYear;
    delete resultSize; 
}

int main() {
    int ARRAY_SIZE = 5;
    song **songArray = new song*[ARRAY_SIZE];

    // Create and store dynamically allocated song structs
    songArray[0] = new song;
    songArray[0]->title = "Bring Da Ruckus";
    songArray[0]->artist = "Wu Tang Clan";
    songArray[0]->year = 1993;

    songArray[1] = new song;
    songArray[1]->title = "Electric Relaxation";
    songArray[1]->artist = "A Tribe Called Quest";
    songArray[1]->year = 1993;

    songArray[2] = new song;
    songArray[2]->title = "Red Barchetta";
    songArray[2]->artist = "Rush";
    songArray[2]->year = 1981;

    songArray[3] = new song;
    songArray[3]->title = "Caught in a Web";
    songArray[3]->artist = "Dream Theater";
    songArray[3]->year = 1994;

    songArray[4] = new song;
    songArray[4]->title = "Ready to Start";
    songArray[4]->artist = "Arcade Fire";
    songArray[4]->year = 2010;

    // Test songToString function: 
    cout << "All songs:\n";
    for (int i = 0; i < ARRAY_SIZE; i++) {
        cout << songToString(*songArray[i]);
    }
    cout << "\n";

    // Test songsFromYear function:
    testSongsFromYear(songArray, ARRAY_SIZE, 2000);
    testSongsFromYear(songArray, ARRAY_SIZE, 1993);
    testSongsFromYear(songArray, ARRAY_SIZE, 2010);
    testSongsFromYear(songArray, ARRAY_SIZE, 1981);
    testSongsFromYear(songArray, ARRAY_SIZE, 2020);

    // Clean up memory ensuring one delete for every new.
    for (int i = 0; i < ARRAY_SIZE; i++) {
        delete songArray[i];
    }
    delete [] songArray;

    return 0;
}