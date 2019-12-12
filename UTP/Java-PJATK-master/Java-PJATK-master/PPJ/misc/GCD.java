import java.util.Scanner;
public 
	class GCD{
		public static void main(String[]arg){
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter 2 numbers");
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c;
			if (a==0){
				System.out.println("Error");
			}
			else{
			while(a>0){
				if (a==b){
				System.out.println("GCD = "+ a);
					break;
			}
			else if (a < b){
				c = a;
				a = b;
				b = c;
			}
				else{
					a = a-b;
				}
				}
			}
			sc.close();
		}
	}