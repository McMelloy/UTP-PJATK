#include "pch.h"
#include <iostream>
#include <ctime>

using namespace std;

void alive()
{
	cout << "Alive";
}

void dead()
{
	cout << "Dead";
}

void (*lucky())()
{
	srand(time(NULL));
	int r = 1 + rand() % 6;
	cout << r << endl;
	if (r < 6)
		return dead;
	else
		return alive;
}

//Task 2 - Integral
double f(double x)
{
	return x * x + 4*x + 3;
}


int main()
{
	lucky()(3);
}
