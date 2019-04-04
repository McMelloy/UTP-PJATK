#include "pch.h"
#include <iostream>

using namespace std;

int length(const char* c) {
	const char* tmp = c;
	int res = 0;
	while (*tmp)
	{
		res++;
		tmp++;
	}
	return res;
}

//char* copy(const char* c) {
	//char* copy;
	//strcpy(copy, c);
	//return copy;
//}

bool palindrome(const char* c) {
	int len = length(c);
	int count = 0;
	const char *f = c;
	const char *e = c+len-1;
	while (count <= len / 2)
	{
		if (*f != *e)
			return false;
		f++;
		e--;
		count++;
	}
	return true;
}

int main()
{
	// easiest way
	const char *c = "tacocat";

	// todo: display the text
	//cout << length(c);

	//char *cp = copy(c);
	cout << palindrome(c) << endl;
}
