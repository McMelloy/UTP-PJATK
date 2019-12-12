import java.util.Scanner;
public class P123{
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();

		for(int n=-5; n<= 5; n++) {
		boolean inSum = (n >= a && n <= d) ? true : false;
		boolean inIntersect = (n >= c && n <= b) ? true : false;
		boolean inSymDiff = ((n >= a && n <= b)||(n >= c && n <= d) && ! (n>=c && n<=b)) ? true : false;
			System.out.println( n + ":" + " inSum? " + inSum + "; " + "inIntersect? " + inIntersect + "; " + "inSymDiff? " + inSymDiff);
	}
	sc.close();
	}
}