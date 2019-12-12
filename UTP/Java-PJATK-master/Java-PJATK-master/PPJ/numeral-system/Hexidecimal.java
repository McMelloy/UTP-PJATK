
public 
	class Hexidecimal {
		public static void main (String[]args){
			char val ='A';
			if(val >='0' && val<='9')
				System.out.println(val);
			if(val >='A')
				System.out.println(10);
			if(val >='B')
				System.out.println(11);
			if(val >='C')
				System.out.println(12);
			if(val >='D')
				System.out.println(13);
			if(val >='E')
				System.out.println(14);
			if(val >='F')
				System.out.println(15);
			
			//-------------------
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