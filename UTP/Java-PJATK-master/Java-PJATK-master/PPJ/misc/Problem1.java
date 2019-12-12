import java.util.Scanner;
public 
	class Problem1{
		public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
			double a = sc.nextInt();
			String s1= sc.next();
			double b = sc.nextDouble();
			sc.close();

			if (s1.equals("+")) {
				System.out.println(a+b);
			}
			 else if(s1.equals("-")) {
				System.out.println(a-b);
				}
				
			 else if (s1.equals("*")){
				System.out.println(a*b);
			 }
			 else if (s1.equals("/")){
				System.out.println(a/b);
			 }
				sc.close();
		}
	}