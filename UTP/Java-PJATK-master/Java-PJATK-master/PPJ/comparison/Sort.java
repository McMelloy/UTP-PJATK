public class Sort{
	public static void main(String[] args){
		int a=8, b=12, c=3;
		if (a>b){
			if(b>c){
				System.out.println(a +" "+ b +" "+c);
			}
			else {											//a<b
				if(a>c){
					System.out.println(a+" "+c+" "+b);
				}
				else if(c>a){
					System.out.println(c+" "+a+" "+b);
				}
			}
		}
		else {                        //(b>a)
			if(a>c){
				System.out.println(b+" "+a+" "+c);
			}
			else {
				if(b>c){
					System.out.println(b+" "+c+" "+a);
				}
				else if(c>b){
					System.out.println(c+" "+b+" "+a);
				}
			}		
		}
	}
}