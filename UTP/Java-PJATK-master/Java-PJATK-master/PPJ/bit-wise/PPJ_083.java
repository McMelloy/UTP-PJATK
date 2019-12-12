
public class PPJ_083 {
    public static void main(String[] args) {
        info(encode(130999,101,7777,99,7000,6));
    }

    public static long encode(int caller, int caller_zone,
                              int callee, int callee_zone,
                              int duration, int tariff) {
        long enc;
        int caller_t1= caller;
        int caller_zone_t1 = caller_zone;
        int callee_t1= callee;
        int callee_zone_t1= callee_zone;
        int duration_t1= duration;
        int tariff_t1= tariff;

        caller_t1<<=(check(caller,17));
        caller_t1>>>=(check(caller,17));

        caller_zone_t1<<=(check(caller_zone,7));
        caller_zone_t1>>>=(check(caller_zone,7));
        
        callee_t1<<=(check(callee,17));
        callee_t1>>>=(check(callee,17));
        
        callee_zone_t1<<=(check(callee_zone,7));
        callee_zone_t1>>>=(check(callee_zone,7));
        
        duration_t1<<=(check(duration,13));
        duration_t1>>>=(check(duration,13));
        
        tariff_t1<<=(check(tariff,3));
        tariff_t1>>>=(check(tariff,3));

        enc = caller_t1;
        enc<<=7;
        enc+=caller_zone_t1;
        enc<<=17;
        enc+=callee_t1;    
        enc<<=7;
        enc+=callee_zone_t1;
        enc<<=13;
        enc+=duration_t1;
        enc<<=3;
        enc+=tariff_t1;
        System.out.println(Long.toBinaryString(enc));
        return enc;
    }
    public static int check(int n, int bitL){
        int count = 0;
        int mask = 1;
        for( int i=1; i<=bitL; i++){
            if( (n & (mask << i)) != 0)
                count=i;
        }
        count+=1;
        return count=bitL-count;
    }
    public static void info(long res) {
       
        { long n=res;
        long caller = n >>> 47;
        System.out.println(caller);
        }
        {long n=res;
        n<<=17;
        long caller_zone = n>>> 57;  
        System.out.println(caller_zone);
        }
        {long n=res;
        n <<=24;
        long callee = n >>> 47; 
        System.out.println(callee);
        }
        {long n=res;
        n <<=41;
        long callee_zone = n >>> 57;
        System.out.println(callee_zone);
        }
        {long n=res;
        n <<=48;
        long duration = n >>> 51;  
        System.out.println(duration);
        }
        {long n=res;
        n <<=61;
        long tariff = n >>> 61;  
        System.out.println(tariff);
        }
    }     
}  
    
