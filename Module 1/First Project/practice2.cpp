#include <iostream>

using namespace std;

bool flipFlag(bool flag)
{
  return !flag;
}

int main()
{
  /*bool flag = true;

  cout << flag << endl;
  flag = flipFlag(flag);
  cout << flag << endl;*/

  /*int i = 10;
  cout << "T-minus ";
  while(i >= 0) {
      cout << i << endl;
      i--;
  }
  cout << "Lift off!";*/

  char cont;
  do {
      cout << "Go Cadets!\n";
      cout << "Do you want more? Type Y if yes: \t";
      cin >> cont;
  } while(cont == 'Y');

  return 0;
}