public class DNA {
    public static int simil(String a, String b) {
        int point = 0;
        String temp = "";
        int match=0;
        int count=0;
        String max = a.length() > b.length() ? a : b;
        String min = a.length() > b.length() ? b : a;

        // "GCGC";
        // "AGGGCA";
        for(int i = 0; i < max.length()-min.length()+1; i++) {//1
            temp = max.substring(i, min.length()+i);// ctacg
            for(int j = 0; j < temp.length(); j++){//1
                if(temp.charAt(j)==min.charAt(j)){ //f
                    count++; //0
                    if(j == temp.length()-1){
                        match+= count*count;//
                        count = 0;
                    }
                }
                else {
                    match+= count*count;//0           
                    count = 0;
                    //
                }
            }
            System.out.println("before"+match);//
            point = match >= point? match : point;//
            System.out.println(point);
            match=0;
        }

        return point;
    }

    public static void main (String[] args) {
        String a = "AACTACGTC";
        String b =   "ACGTA";
        System.out.println(a + " and " + b +
                       " -> " + simil(a, b));
        String c = "GCGC";
        String d = "AGGGCA";
        System.out.println(c + " and " + d +
                       " -> " + simil(c, d));
    }
}