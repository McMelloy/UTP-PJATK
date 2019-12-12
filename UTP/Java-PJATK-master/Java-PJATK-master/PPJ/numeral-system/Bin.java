import java.util.Scanner;
public 
	class Bin {
		public static void main(String[]args){
			//from decimal to binary
			Scanner scan = new Scanner(System.in);
			int count=0;
			int bit0=scan.nextInt();
			int bit1=scan.nextInt();
			int bit2=scan.nextInt();
			int bit3=scan.nextInt();
			if (bit0==1)
				 count+=1;
			if (bit1==1)
				 count+=2;
			if (bit2==1)
				 count+=4;
			if (bit3==1)
				 count+=8;
			System.out.println(count);
			//--------------
			System.out.println(
			  (bit0*1)+(bit1*2)+(bit2*4)+(bit3*8)
			);
			System.out.println(
			(bit3 * 0b1000)+
			(bit2 * 0b0100)+
			(bit1 * 0b0010)+
			(bit0 * 0b0001)
				);
				sc.end();
		}
	}