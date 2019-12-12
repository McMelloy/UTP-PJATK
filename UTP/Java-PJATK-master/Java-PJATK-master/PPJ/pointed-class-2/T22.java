import java.util.Random;
import java.util.Scanner;
public
	class T22{
		public static void table(){
			Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
			Random r = new Random();

			for(int k=1; k<(n+1); k++){
				for(int a=1; a<=n; a++){
					int ranVal = r.nextInt((10 - (-10) +1))+(-10);
					System.out.printf("%4d", ranVal);
				}
				System.out.println();
			}
			sc.close();
        }
        public static void main(String []args){
            table();
        }
	}