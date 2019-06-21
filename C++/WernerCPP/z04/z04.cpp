#include "pch.h"
#include <iostream>

using namespace std;

int x;

size_t length(const char* cstr)
{
	size_t res = 0;
	while (*(cstr + res) != '\0')
		res++;
	return res;
}
bool isLetter(char c)
{
	return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
}
char* reverse(char* cstr)
{
	size_t size = length(cstr);
	char* res = new char[size+1];
	for (int i = 0; i < size; i++) {
		res[i] = cstr[size - (i+1)];
	}
	res[size] = 0;
	return res;
}
size_t words(const char* cstr)
{
	size_t count = 0;
	size_t size = length(cstr);
	bool wordCurrently = false;
	for (int i = 0; i < size+1; i++) {
		if (!wordCurrently && isLetter(cstr[i]))
			wordCurrently = true;
		if (wordCurrently && !isLetter(cstr[i])) {
			count++;
			wordCurrently = false;
		}
	}
	return count;
}
char* concat(char* t, const char* s);

int main()
{
	char s1[] = "Alice in Wonderland"; 
	char* s1r = reverse(s1);
	cout << "reverse: " << length(s1r) << endl;
	delete[] s1r;
	cout << "orig: " << length(s1) << endl;
	cout << "Words: " << words(s1) << endl;
	char s2[] = " ... for (int i = 0; i < n; ++i){...} ..."; cout << "words : " << words(s2) << endl;
	char s3[100] = "Hello"; 
	//char* s3c = concat(s3, ", world");
	//cout << "concat : " << s3c << endl;
	//delete[] s3c;

	cout << x;
}
