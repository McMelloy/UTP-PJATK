public class Task4 {
 
    public static void main(String[] args) {
        int[] fir = {2, 4, 3, 6, 7,6, 8,2,9};
        int[] sec = {2, 3, 6, 8, 1, 5};
 
        boolean repeat=false;
        boolean same=false;
        for(int i=0;i<fir.length;i++){
            repeat = false;
            same=false;
            for(int j=0;j<sec.length;j++){
                if(fir[i]==sec[j]) {
                    same=true;
                }
            }
            for(int k=0;k<i;k++){
                if(fir[i]==fir[k])
                    repeat = true;
            }
            if(!repeat && !same) {
                System.out.println(fir[i]);
            }
        }
    }
}