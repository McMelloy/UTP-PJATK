// Class1.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include "pch.h"
#include <iostream>
#include <array>

using namespace std;

namespace pjatk 
{
	void say_hello()
	{
		cout << "Demetrius Baranowski hails U!" << endl;
	}
}

array<int,2> solveQuadratic(int a, int b, int c)
{
	int D = pow(b, 2) - 4 * a*c;
	if (D >= 0)
	{
		int x1 = (-b + sqrt(D)) / 2*a;
		int x2 = (-b - sqrt(D)) / 2*a;
		return { x1,x2 };
	}
	else return { NULL, NULL };
}

int countEven() {
	int sum = 0;
	cout << "Input numbers, I'll count even ones. To stop, type 0" << endl;
	int type;
	do{
		cin >> type;
		if (type % 2 == 0)
			sum += type;
	} while (type != 0);
	return sum;
}

int main()
{
    cout << "Hello World!\n"; 
	pjatk::say_hello();
	int a, b, c;
	/*cout << "Input a, b, c" << endl;
	cin >> a >> b >> c;
	array<int, 2> res = solveQuadratic(a, b, c);
	cout << "x1: "<<res[0] << "\nx2: "<<res[1] << endl;
	*/
	cout << countEven() << endl;
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
