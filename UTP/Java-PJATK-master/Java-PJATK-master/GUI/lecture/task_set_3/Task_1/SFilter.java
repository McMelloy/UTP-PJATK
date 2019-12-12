@FunctionalInterface
interface SFilter{
    boolean test(String s);

    public static String[] filter(String[] arr, SFilter filt) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(filt.test(arr[i])){
                count++;
            }
        }
        String[] fin = new String[count];
        for(int i = 0, k=0; i < arr.length; i++){
            if(filt.test(arr[i])){
                fin[k] = arr[i];
                k++;
            }
        }
        return fin;
    }
}


