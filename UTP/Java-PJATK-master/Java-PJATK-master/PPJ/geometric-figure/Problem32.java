/*for (int k = 0; k < arr.length; k++) {
	System.out.println(arr[k]);
}*/
import java.util.Scanner;
public
	class Problem32{
		public static void main(String[]args){
			Scanner sc =new Scanner(System.in);
			System.out.println("Enter odd natural number");
			int n =sc.nextInt();
			sc.close();

			for(int ver = 1 ,sp = 0; ver <= n; ver+=2,sp++){
				for(int i=1; i<=sp; i++){
					System.out.print(" ");
				}
				for(int gor=n; gor>=ver; gor--){
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
	