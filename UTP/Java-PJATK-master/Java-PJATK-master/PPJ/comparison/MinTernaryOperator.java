import java.util.Scanner;
public
	class MinTernaryOperator{
	public static void main (String[]args){
	Scanner scan= new Scanner(System.in);
	int a = scan.nextInt();
	int b = scan.nextInt();
	int c = scan.nextInt();
	int min = (a<b)? a:b;
	min= (min<c)? min:c;
	System.out.println(min);
	scan.close();
	} 
		
	}