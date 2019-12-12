import java.util.Scanner;
public 
	class MT{
		public static void main(String[]args){
			Scanner sc = new Scanner(System.in);
			int n = 10;
			for(int k=1; k<(n+1); k++){
				for(int a=1; a<=n; a++){
					System.out.printf("%4d",(a*k));
				}
				System.out.println();
			}
			sc.close();
		}
	}