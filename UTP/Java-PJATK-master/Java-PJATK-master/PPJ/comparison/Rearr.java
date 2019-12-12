import java.util.Scanner;

public class Rearr {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int min = (a <= b) ? a : b;
		min = (min <= c) ? min : c;
		int max = (a >= b) ? a : b;
		max = (max >= c) ? max : c;
		int mid = (a >= b) ? b : a;
		mid = (mid >= c) ? mid : c;
		a = min;
		b = mid;
		c = max;
		System.out.println(a + ", " + b + " " + c);
		scan.close();
	}
}