public class qwe {
	
    public static void main(String[] args) {
		
        int[] arr = {5,9};
		int from = 0;
		int to = 5;
		
		System.out.println(getMax(arr, from, to));
		
	}
	
	public static int getMax(int arr[], int from, int to) {
		
		if(from == to - 1) { 
			return arr[from];
		}
		
		else {
		
        if(Math.max(arr[from], arr[to - 1]) == arr[from]){
			return getMax(arr, from, --to);
		}
		else {
			return getMax(arr, ++from, to);
		}
		
		}
		
    }
	
}
