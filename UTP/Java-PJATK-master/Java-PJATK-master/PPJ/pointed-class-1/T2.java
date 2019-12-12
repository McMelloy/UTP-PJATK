public class T2{
	public static void main(String[] args){
		boolean stat;
		int a;
		 if(Math.random()>0.5){
			 stat = true ;
		 }
			else 
				stat = false;	 
		
		 a = (stat==true)? 5:8;
		System.out.println(a);
	}
}