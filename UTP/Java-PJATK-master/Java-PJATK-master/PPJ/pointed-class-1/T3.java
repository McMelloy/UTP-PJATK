public class T3{
	public static void main(String[]args){
		char val ='A';
			switch(val){
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					System.out.println(val);
					break;
				case 'A':
				case 'B':
				case 'C':
				case 'D':
				case 'E':
				case 'F':
					System.out.println(10 + val - 'A');
					break;
			}
	}
}