public class Test{
    public static void main(String[] args) {
        int [] arr = {3,3,3};
        /*01
        02
        03
        04
        05
        12
        13
        14
        15
        23
        24
        25
        34
        35
        45
            =15  5
        01
        02
        03
        04
        12
        13
        14
        23
        24
        34
            =10  4
        01
        02
        03
        12
        13
        23
            =6   3
        01
        02
        12 = 3    2
    
        */
        int count = 0;
        for(int i = 0; i< arr.length; i++) {
            for(int j = i+1; j < arr.length; j++ ) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
        }
    }
}