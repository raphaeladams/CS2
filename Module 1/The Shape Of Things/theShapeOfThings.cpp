#include <iostream>
#include <cmath>

using namespace std;

int main(int argc, char** argv) {
    // iterate row by row
    for (int row = 1; row <= 10; row++) {
        // Calculate thickness of 1 side of the X figure, at given row number. 
        // The 2 hashes in the very center of the figure are ignored for now:
        int figureThicknessOneSide = (5.5 - abs(5.5 - row)); 

        // Iterate across current row, each character forming a "column".
        // Place '#' and ' ' in correct positions based on figure thickness.
        // Finally, include a condition to print the 2 hashes in the center (rows 5-6). 
        for (int columnNum = 1; columnNum <= 19; columnNum++) {

            bool drawingFigureLeftSide = 
                (columnNum >= figureThicknessOneSide && columnNum <= (2*figureThicknessOneSide - 1));
            bool drawingFigureRightSide = 
                (columnNum >= (21 - 2*figureThicknessOneSide) && columnNum <= (20 - figureThicknessOneSide));
            bool drawingFigureCenter = 
                (columnNum == 10 && figureThicknessOneSide == 5);

            if (drawingFigureLeftSide || drawingFigureRightSide || drawingFigureCenter) {
                cout << '#';
            } else {
                cout << ' ';
            }
        }
        cout << '\n';
    }  
    return 0;
}