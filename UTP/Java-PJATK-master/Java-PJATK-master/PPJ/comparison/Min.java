import java.util.Scanner;
public class Alice{
	
	public static void main(String[]args){
		//find the least 
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=scan.nextInt();
		if (a<b && a<c) {
		System.out.println(a);
		}
			else if (b<a && b<c){
			System.out.println(b);
		}
			else if (c<b && c<a){
			System.out.println(c);
		}
		scan.close();
	}
	}