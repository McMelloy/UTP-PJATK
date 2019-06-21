// Class4.cpp : This file contains the 'main' function. Program execution begins and ends there.
//
#include "pch.h"
#include <iostream>

using std::cout;
using std::endl;

void fun(int x) 
{
	x = x + 1;
}

void fun2(int* x)
{
	*x = *x + 1;
}

int main()
{
	int x = 10;
	int y = 20;

	cout << "address of x: " << &x << endl;
	cout << "show value of x using its address: " << *(&x) << endl;

	int* px = &x;

	*px += 3;
	cout << "x now: " << x << endl;
	px = &y;
	cout << "px now: " << *px << endl;
	fun(x);
	cout << x << endl;
	fun2(&x);
	cout << x << endl;

	/*int size;
	cout << "Type a size for the array: ";
	std::cin >> size;

	int *arr = new int[size];

	for (int i = 0; i < size; ++i)
	{
		std::cin >> arr[i];
	}

	cout << *arr << endl;
	

	delete[] arr;*/
	int arr[] = { 2, 5, 6 };
	*arr = *(arr + 1)+2;
	cout << arr[0] << endl;
}