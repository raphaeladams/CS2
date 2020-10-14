#include <iostream>
using namespace std;

void changeValue(int *element)
{
  *element += 999;
}

int main()
{
  int stuff[5];

  for (int i=0; i < 5; i++)
  {
    stuff[i] = i;
  }

  int *otherStuff = stuff;

  for (int i=0; i < 5; i++)
  {
    otherStuff[i] = i*2;
  }

  changeValue(&(otherStuff[0]));

  for (int i=0; i < 5; i++)
  {
    cout << stuff[i] << endl;
  }

  return 0;
}