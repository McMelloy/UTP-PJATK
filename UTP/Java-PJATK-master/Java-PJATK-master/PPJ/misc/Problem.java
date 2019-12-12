import java.util.Scanner;
public 
	class Problem{
		public static void main (String[]args){
			Scanner sc=new Scanner(System.in);
			
			int a = sc.nextInt(); 
			int max = 0;
			int lastVal;
			int quant = 1;
			int num = 0;
			while(a != 0){
				lastVal = a;
				a = sc.nextInt();	
				if (a == lastVal){
					quant++;	
					}
				else {
					if (max < quant){
						max = quant;
						num = lastVal;
					}
					quant = 1;
				}
				}
			System.out.println(num + "times" + max);
			sc.close();
				}
			}