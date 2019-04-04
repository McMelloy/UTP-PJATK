#include "pch.h"
#include <iostream>
#include <string>

using namespace std;

namespace Task5 {
	enum hey {
		Hey, Adios, Satan
	};
	struct A {
		int a;
		double b;
		string c;
	};
	A create() {
		A input;
		cout << "Enter the int value" << endl;
		cin >> input.a;
		cout << "Enter the double value" << endl;
		cin >> input.b;
		cout << "Enter the string definition" << endl;
		cin >> input.c;
		return input;
	};
	string to_stringA(A in) {
		cout << "Int: " << in.a << "\n" << "Double: " << in.b << "\n" << "String: " << in.c << endl;
		return in.c;
	};
};


enum country
{
	Canada, Norway, Austria, NewZealand
};


struct point_3d
{
	int x;
	int y;
	int z;
};

struct university
{
	int year;
	country origin;
	int numOfStudents;
	int numOfProfessors;
	string head;
};

struct student
{
	string name;
	int grade;
};

student create()
{
	student s;
	getline(cin, s.name);
	cin >> s.grade;
	return s;
}

string to_string(student s)
{
	return "Student " + s.name;
}

student create();
string to_string(student);

int main()
{
	//student stud = create();
	//cout << to_string(stud) << endl;
	Task5::A case_a = Task5::create();
	Task5::to_stringA(case_a);
}


