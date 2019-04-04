#include "pch.h"
#include <iostream>

using namespace std;

int strlen(char* c) {
	char* tmp = c;
	int res = 0;
	while (*tmp)
	{
		res++;
		tmp++;
	}
	delete[] tmp;
	return res;
}

int main()
{
	// easiest way
	const char *c = "this is a text";

	// acceptable by standard
	//char *cc = new char[100];
	//strcpy(cc, "this is a text");

	// todo: display the text
	cout << strlen(c);

	delete[] c;
	//delete[] cc;
}
