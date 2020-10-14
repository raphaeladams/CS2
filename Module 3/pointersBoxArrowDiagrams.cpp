#include <iostream>
#include <cmath>

using namespace std;

struct console
{
  bool on;
};

int main(int argc, char** argv) 
{
  console *c1;
  console c2;
  console c3;

  c2.on = true;
  c1 = &c2; /* 1 */
  c3.on = c1->on;
  c1 = &c3; /* 2 */
  c2.on = false; /* 3 */
 
  cout << "c1: " << c1->on << endl;
  cout << "c2: " << c2.on << endl;
  cout << "c3: " << c3.on << endl;
}