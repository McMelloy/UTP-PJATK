import java.util.Scanner;
public
	class P33{
		public static void main(String[]args){
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter 2 natural numbers");
			int h = sc.nextInt();
			int w = sc.nextInt();
			sc.close();
			for (int a=1; a<=w; a++){
				System.out.print("*");
			}// 1 row
			
			System.out.println();	
			
			for (int h1=(h-2); h1>0; h1--){
				System.out.print("*");
				for(int sp=1; (sp>=1) && (sp<=(w-2)); sp++){
					System.out.print(" ");	
			}
				System.out.println("*\n");
			
				for (int a=1; a<=w; a++){
				System.out.print("*");
			}
			
		}
	}

	}