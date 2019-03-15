#include "pch.h"
#include <iostream>
#include <string>

using namespace std;


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
	student stud = create();
	cout << to_string(stud) << endl;
}


