public class LenFilter implements SFilter{
    private int minLen;
    public LenFilter(int a){
        minLen = a;
    }

    @Override
    public boolean test(String s){
        if(s.length() >= minLen){
            return true;
        }else return false;
    }
}