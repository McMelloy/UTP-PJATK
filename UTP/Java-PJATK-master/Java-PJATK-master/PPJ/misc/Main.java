public
	class Main{

	public static void main(String[] args){
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		boolean n = true;
		while(n){
			for(int i = 0; i < arr.length; i++){
				System.out.print(arr[i]+"\t");
			}
			System.out.println(); //????

			int s1 = (int)(Math.random()*arr.length);
			int s2 = (int)(Math.random()*arr.length);

			int tmp = arr[s1];
			arr[s1] = arr[s2];
			arr[s2] = tmp;

			n = false;
			for( int i=0; i<arr.length - 1 && !n; i++){
				if(arr[i] +1 == arr[i+1])
					n = true;
			}
		}
	}

}