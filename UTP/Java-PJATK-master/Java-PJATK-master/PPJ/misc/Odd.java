import java.util.Scanner;
public 
	class Odd{
		public static void main(String []args){
		Scanner scan = new Scanner(System.in);
			int a=scan.nextInt();
			if (a%2==0){
				System.out.println("Even");
			}
			else {
				System.out.println("Odd");
			}
			scan.close();
		}
	}