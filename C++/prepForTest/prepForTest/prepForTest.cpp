
#include "pch.h"
#include <iostream>
#include <ctime>
void win() {
	std::cout << "Win" << std::endl;
}

void lose() {
	std::cout << "Lose" << std::endl;
}

void(*lucky())() {
	if (rand() % 6 == 0) return lose;
	return win;
}

double integral(double start, double end, double step, double(*f)(double)) {
	double s = 0;
	for (double x = start; x < end; x += step) {
		s += (f(x) + f(x + step))*step / 2;
	}
	return s;
}

double fun0(double x) {
	if (x == 0) return 0;
	return sin(x) * x + x * x * 6;
}

void display_row(int *arr, int length) {
	for (int i = 0; i < length; ++i) {
		std::cout << arr[i] << " ";
	}
	std::cout << std::endl;
}

int* generate_rand(int length, int min, int max) {
	int dist = max - min;
	int* tmp = new int[dist];
	for (int i = 0; i < dist; ++i) {
		tmp[i] = min + i;
	}
	for (int i = 0; i < dist; ++i) {
		int from = rand() % dist;
		int to = rand() % dist;
		int n = tmp[from];
		tmp[from] = tmp[to];
		tmp[to] = n;
	}
	display_row(tmp, dist);

	int* arr = new int[length];
	for (int i = 0; i < length; ++i) {
		arr[i] = tmp[i];
	}
	delete[] tmp;
	return arr;
}


int main() {
	srand(time(nullptr));
	/*int x;
	// Task 1
	// I way
	void(*f)() = lucky();
	f();
	// II way
	lucky()();

	// Task 2
	for (double step = 1e-6; step <= 1; step *= 10) {
		std::cout << "integral[step=" << step << "]: " << integral(0, 100, step, fun0) << std::endl;
	}

	// Task 3
	std::cout << integral(0, 100, 1, [](double x) {
		return (x*x + 3.45*x + 123)*sin(x);
	}) << std::endl;*/

	int* arr = generate_rand(10, 0, 100);
	display_row(arr, 10);
	delete[] arr;

	return 0;
}
