public class DayPassed {
    public static void main(String[] args) {
        int day=31;
        int month=12;
        int res=0;
        for(int i=1;i<month;i++){
            if(i==1 | i==3 | i==5 | i==7 | i==8 | i==10 | i==12)
                res+=31;
            else if(i==2)
                res+=28;
            else if(i==4 | i==6 | i==9 | i==11)
                res+=30;
        }
        res+=day;
        System.out.println(res);
    }
}

/* int day =23;
        int =10;
        dayCount=0;

        switch(){
            case 1:
            case 2 :
            case 3:
            case 5
            ...

        }*/