#include <iostream>
using namespace std;

struct jeans
{
 int size;
 float fadeLevel;
};

void fadeJeans(jeans toFade)
{
  toFade.fadeLevel -= 0.05;
}

int main()
{
  int newSize;
  jeans j = {newSize, 0.9};
  fadeJeans(j);
  cout << j.size << " " << j.fadeLevel;
  return 0;
}