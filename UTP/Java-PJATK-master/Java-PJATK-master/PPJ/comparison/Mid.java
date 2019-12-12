import java.util.Scanner;
public
	class Mid{
	public static void main (String[]args){
	Scanner scan= new Scanner(System.in);
	int a = scan.nextInt();
	int b = scan.nextInt();
	int c = scan.nextInt();
	int mid = (a > b) ? b : a;
    mid = (mid > c) ? mid : c;
    System.out.println(mid);
	scan.close();
	}

	}