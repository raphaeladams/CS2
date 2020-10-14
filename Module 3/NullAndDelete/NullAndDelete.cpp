#include <iostream>
using namespace std;

/* Q2. If we don't check for NULL pointers, my compiler gives this output:

 * pointerArray[0] has the value 1
 * pointerArray[1] has the value 10
 * Segmentation fault: 11
 * 
 * The fault occurs when we try to execute
 * cout << "pointerArray[" << i << "] has the value " << *pointerArray[i] << endl;
 * with pointerArray[2] (which is NULL).
 * 
 * NULL pointers don't point to anything. In the statement above, 
 * we try to dereference pointerArray[2], but there is nothing in the heap 
 * for the program to use, not even an address. This results in "undefined behaviour" 
 * as per https://www.learncpp.com/cpp-tutorial/6-7a-null-pointers/. 
 * On my computer, this in turn gives a segmentation fault.
 */

int main()
{
  int * pointerArray[4];

  pointerArray[0] = new int;
  pointerArray[1] = new int;
  pointerArray[2] = NULL;
  pointerArray[3] = new int;

  *(pointerArray[0]) = 1;
  *(pointerArray[1]) = 10;
  *(pointerArray[3]) = 50;

  // Q1. Print the int values at the addresses indicated by the pointers in the array, 
  // skipping any NULL values.
  for (int i = 0; i < 4; i++) {
      //if (pointerArray[i] != NULL) {
          cout << "pointerArray[" << i << "] has the value " << *pointerArray[i] << endl;
      //}
  }

  // Q1. Delete the memory created, skipping NULL values. 
  // Assign NULL to pointers whose contents have been deleted.
  for (int i = 0; i < 4; i++) {
      if (pointerArray[i] != NULL) {
          delete pointerArray[i];
          pointerArray[i] = NULL; 
      }
  }


  return 0;
}