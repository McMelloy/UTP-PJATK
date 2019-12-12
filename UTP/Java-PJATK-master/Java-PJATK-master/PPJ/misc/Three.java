import java.util.Scanner;
public 
	class Three{
		public static void main(String[]args){
			Scanner scan = new Scanner(System.in);
			int a=scan.nextInt();
			if ((a>=-15 && a<=-10)||(a>-5 && a<=0)){
				System.out.println(true);
			}
			else {
				System.out.println(false);
			}
		}
	}