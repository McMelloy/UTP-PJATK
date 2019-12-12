import java.util.Scanner;
public 
	class T7{
		public static void main(String[]args){
			Scanner sc = new Scanner(System.in);
			int n =11;
			for(int k=1; k<n; k++){
				for(int a=1; a<n; a++){
					System.out.printf("%4d",(a*k));
				}
				System.out.println();
			}
		}
	}

	