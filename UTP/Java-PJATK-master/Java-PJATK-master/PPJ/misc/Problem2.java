import java.util.Scanner;
public 
	class Problem3{
		public static void(String[]args){
			Scanner sc= new Scanner(System.in);
			int a= sc.nextInt();
			int b= sc.nextInt();
			int c= sc.nextInt();
			int d= sc.nextInt();
			int minVal;
			int maxVal;
			if (a<b)&&(a<c)&&(a<d){
				minVal=a;
				}
			else if (b<c)&&(b<d){
				minVal=b
			}
			else if (c<d){
				minVal=c
			}
			else minVal=d;
			
			if (a>b)&&(a>c) && (a>d){
				maxVal=a;
				}
			else if (b>c)&&(b>d){
				maxVal=b
			}
			else if (c>d){
				maxVal=c
			}
			else maxVal=d;
			System.out.println(maxVal-minVal);
			}
		}

	