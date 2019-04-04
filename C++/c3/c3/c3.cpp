
#include "pch.h"
#include <iostream>

using namespace std;

#define constant_size 10


int main() {
	cout << constant_size << endl;
	int arr[constant_size];
	for (int i = 0; i < constant_size; i++)
	{
		arr[i] = 100 - 10 * i;
		cout << arr[i] << endl;
	}
}