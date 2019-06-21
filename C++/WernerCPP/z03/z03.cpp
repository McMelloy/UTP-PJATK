

#include "pch.h"
#include <iostream>

using namespace std;

void minMaxRep(int a[], size_t size, int& mn, size_t& in, int&mx, size_t& ix) 
{
	mn = a[0];
	mx = a[0];
	in = 0, ix = 0;
	for (size_t i = 0; i < size; i++)
	{
		if (a[i] < mn) {
			mn = a[i];
			in = 1;
		}
		else if (a[i] == mn)
			in++;
		if (a[i] > mx) {
			mx = a[i];
			ix = 1;
		}
		else if (a[i] == mx)
			ix++;
	}
}

const double* aver(const double* arr, size_t size, double& average) {
	average = 0;
	for (int i = 0; i < size; i++)
	{
		average += *(arr + i);
	}
	average /= size;
	double diff = abs(*arr - average);
	const double* res = &(*arr);
	for (int i = 0; i < size; i++)
	{
		double tmp = abs(arr[i] - average);
		if (tmp < diff) {
			diff = tmp;
			res = &arr[i];
		}
	}
	return res;
}

void getMinMax(double &a, double& b, double& c, double*& ptrMin, double*& ptrMax) {
	if(a > b){
		if (a > c) {
			ptrMax = &a;
			if (c > b)
				ptrMin = &b;
			else
				ptrMin = &c;
		}
		else { //c>a
			ptrMax = &c;
			ptrMin = &b;
		}
	}
	else {//b>a
		if (b > c) {
			ptrMax = &b;
			if (c > a)
				ptrMin = &a;
			else
				ptrMin = &c;
		}
		else { //c>b
			ptrMax = &c;
			ptrMin = &a;
		}
	}
}
void getMinMax(double *a, double* b, double* c, double** ptrMin, double** ptrMax) { 
	if (*a > *b) {
		if (*a > *c) {
			*ptrMax = a;
			if (*c > *b)
				*ptrMin = b;
			else
				*ptrMin = c;
		}
		else { //c>a
			*ptrMax = c;
			*ptrMin = b;
		}
	}
	else {//b>a
		if (*b > *c) {
			*ptrMax = b;
			if (*c > *a)
				*ptrMin = a;
			else
				*ptrMin = c;
		}
		else { //c>b
			*ptrMax = c;
			*ptrMin = a;
		}
	}
}

void swap(double& a, double& b) {
	double tmp = a;
	a = b;
	b = tmp;
}
void swap(double* a, double* b) {
	double tmp = *a;
	*a = *b;
	*b = tmp;
}
void ord3(double& a, double& b, double& c) { 
	if (a > b)
		swap(a, b);
	if (b > c)
		swap(b, c);
	if (a > b)
		swap(a, b);
}
void ord3(double* a, double* b, double* c) { 
	if (*a > *b)
		swap(a, b);
	if (*b > *c)
		swap(b, c);
	if (*a > *b)
		swap(a, b);
}
void printOrd(const double* a, const double* b, const double* c) {
	cout << *a << " " << *b << " " << *c << endl; 
} 
void printMinMax(const double* pmn, const double* pmx) { 
	cout << "Min = " << *pmn << "; " << "Max = " << *pmx << endl; 
}



int main() 
{ 
	//task 1
	/*int a[]{ 2,3,4,2,7,4,7,2 }; 
	size_t size = sizeof(a) / sizeof(*a); 
	int mn, mx; 
	size_t in, ix; 
	minMaxRep(a, size, mn, in, mx, ix); 
	cout << "Array: [ "; 
	for (size_t i = 0; i < size; ++i) 
		cout << a[i] << " "; 
	cout << "]\n"; cout << "Min = " << mn << " " << in << " times\n"; 
	cout << "Max = " << mx << " " << ix << " times\n"; */

	//task 2
	/*double arr[] = { 1,7,5,4,3,2 }; 
	size_t size = sizeof(arr) / sizeof(arr[0]); 
	double average = 0; 
	const double* p = aver(arr, size, average); 
	cout << *p << " " << average << endl;*/

	//task 3
	double q = 1;
	double w = 2;
	cout << q << w << endl;
	swap(&q, &w);
	cout << q << w << endl;

	double a, b, c, *ptrMin, *ptrMax;
	a = 2; b = 1; c = 3; 
	ord3(a, b, c);
	printOrd(&a, &b, &c); 
	a = 3; b = 2; c = 1; 
	ord3(&a, &b, &c); 
	printOrd(&a, &b, &c); 
	a = -1; b = -1; c = 1; 
	ord3(&a, &b, &c); 
	printOrd(&a, &b, &c);

	a = 2; b = 3; c = 1; 
	getMinMax(a, b, c, ptrMin, ptrMax); 
	printMinMax(ptrMin, ptrMax); 
	a = 3; b = 1; c = 2; 
	getMinMax(&a, &b, &c, &ptrMin, &ptrMax); 
	printMinMax(ptrMin, ptrMax); 
	a = 3; b = 3; c = -1; 
	getMinMax(&a, &b, &c, &ptrMin, &ptrMax); 
	printMinMax(ptrMin, ptrMax);


}