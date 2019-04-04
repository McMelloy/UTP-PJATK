#include "pch.h"
#include <iostream>
#include <ctime>
#include <fstream>


using namespace std;

#define constant_size 10


int main() {
	int arr[constant_size];
	for (int i = 0; i < constant_size-1; i++)
	{
		arr[i] = 100 - 10 * i;
	}
	for (int i = 0; i < constant_size + 1; i++)
	{
		cout << arr[i] << endl;
	}
	srand(time(0));
	cout << "[0, " << 100 << "]: " << rand()%100 << endl;

	fstream file;
	file.open("results.txt", std::ios::out);// | std::ios::app - to append
	if (file.good())
	{
		file << "1 2 3" << endl;
		file.close();
	}
	file.open("results.txt", std::ios::in);
	if (file.good())
	{
		int x, y, z;
		file >> x >> y >> z;
		file << x << y << z;
		file.close();
	}
}