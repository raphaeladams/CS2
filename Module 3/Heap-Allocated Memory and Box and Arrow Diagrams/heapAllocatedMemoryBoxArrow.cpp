#include <iostream>
using namespace std;

struct dynamicNum
{
  int *theNumber;
};


int main()
{
  dynamicNum staticStruct;
  staticStruct.theNumber = new int;
  *(staticStruct.theNumber) = 10; /* 1 */

  dynamicNum *dynamicStruct = new dynamicNum;
  dynamicStruct->theNumber = new int;
  *(dynamicStruct->theNumber) = 55; /* 2 */

  cout << "Static struct pointer: "
       << staticStruct.theNumber << endl;
  cout << "Static struct number: "
       << *(staticStruct.theNumber) << endl;

  cout << "Dynamic struct pointer: "
       << dynamicStruct->theNumber << endl;
  cout << "Dynamic struct number: "
       << *(dynamicStruct->theNumber) << endl;

  delete staticStruct.theNumber;
  delete dynamicStruct->theNumber; /* 3 */
  delete dynamicStruct;
}