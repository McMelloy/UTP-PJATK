
#include "pch.h"
#include <iostream>

using namespace std;

#define MIN -200000000;
#define MAX 200000000;

void longestSeq() {
	int current = -1;
	int curseqcount = 0, longseqcount = 0;
	int curseqnum = 0, longseqnum = 0;
	while (current != 0) {
		cin >> current;
		if (current != curseqnum) {
			if (curseqcount > longseqcount) {
				longseqcount = curseqcount;
				longseqnum = curseqnum;
			}
			curseqcount = 1;
			curseqnum = current;
		}
		else {
			curseqcount++;
		}
	}
	cout << "Longest sequence: " << longseqnum << " " << longseqcount << " times" << endl;
}

void minMaxInSeq() {
	int current = -1;
	int max = MIN;
	int min = MAX;
	int maxcount = 0, mincount = 0;
	while(true) {
		cin >> current;
		if (current == 0)
			break;
		if (current < min) {
			min = current;
			mincount = 1;
		}
		else if (current == min)
			mincount++;
		if (current > max) {
			max = current;
			maxcount = 1;
		}
		else if (current == max)
			maxcount++;
	}
	cout << "Max: " << max << " " << maxcount << " times" << endl;
	cout << "Min: " << min << " " << mincount << " times" << endl;
}

int main()
{
	//task 1
	longestSeq();

	//task2
	//minMaxInSeq();
}
