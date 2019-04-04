import java.util.Arrays;


@FunctionalInterface
interface SFilter{
    boolean test(String s);
    static String[] filter(String[] arr, SFilter filt) {
        int count=0;
        for (String s:arr) {
            if(filt.test(s))
                count++;
        }
        String[] res = new String[count];
        count = 0;
        for (String s:arr) {
            if(filt.test(s)) {
                res[count]=s;
                count++;
            }
        }
        return res;
    }
}

class LenFilter implements SFilter{
    int minLen;
    LenFilter(int len){
        minLen = len;
    }
    public boolean test(String s){
        return s.length() >= minLen;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] arr = {"Alice", "Sue", "Janet", "Bea"};
        System.out.println(Arrays.toString(arr));
        LenFilter filter = new LenFilter(5);
        String[] a1 = SFilter.filter(arr,filter);
        System.out.println(Arrays.toString(a1));
        String[] a2 = SFilter.filter(arr,(s)-> (s.charAt(0)>='A' && s.charAt(0)<'D'));
        System.out.println(Arrays.toString(a2));
        SFilter filt = new SFilter(){
            @Override
            public boolean test(String s){
                return (s.charAt(0)>='H' && s.charAt(0)<'Z');
            }
        };
        String[] a3 = SFilter.filter(arr, filt);
        System.out.println(Arrays.toString(a3));



    }
}

/////////////////////////////////////////// TASK 2
@FunctionalInterface
interface Transform<T, R>{
    R apply(T s);
}
class StrToInt implements Transform<String, Integer>{
    public Integer apply(String s){
        return s.length();
    }
}
class GenTrans {
    private static <T, R> void transform(T[] in, R[] out, Transform<T, R> trans) {
        for(int i =0;i<in.length;i++){
            out[i] = trans.apply(in[i]);
        }
    }
    public static void main (String[] args) {
        String[] sin = {"Alice", "Sue", "Janet", "Bea"};
        System.out.println(Arrays.toString(sin) + '\n');

        Integer[] iout = new Integer[sin.length];
        transform(sin, iout, new StrToInt());
        System.out.println(Arrays.toString(iout));

        Character[] cout = new Character[sin.length];
        transform(sin, cout, new Transform<String, Character>() {
            @Override
            public Character apply(String s) {
                return s.charAt(0);
            }
        });
        System.out.println(Arrays.toString(cout));

        String[] sout = new String[sin.length];
        transform(sin, sout, x -> {
                    return x.toUpperCase();
        });
        System.out.println(Arrays.toString(sout));
    }
}
