public class StringMisc{
    public static String norm(String name){
        return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase() ;
    }
    public static String init(String name){
        String[] a = name.split(" ");
        a[0] = a[0].substring(0,1).toUpperCase() + ". ";
        if(a.length == 3){
        a[1] = a[1].substring(0,1).toUpperCase() + ". ";
        a[2] = norm(a[2]);
        name = a[0] + a[1] + a[2];
        } else {
            a[1] = norm(a[1]);
            name = a[0] + a[1];
        }
       return name;
    }

    public static String tr(String s, String from, String to){
        String[] a = s.split("");
        
        for(int i = 0; i < a.length; i++){
            if(from.contains(a[i])){
                int d = from.indexOf(a[i]);
                char l = to.charAt(d);
                a[i] = "" + l;
            }
        }
        String f = "";
        for(String n : a){
            f = f.substring(0, f.length()) + n.substring(0);
        }
        return f;
    }

    public static void main(String[] args){
        System.out.println(norm("caravaggio"));
        System.out.println(norm("VERMEER"));
        System.out.println(init("johann sebastian bach"));
        System.out.println(init("i. babeL"));
        System.out.println(init("jorge LUIS BORGES"));
        System.out.println(init("WOLFGANG a. mozart"));
        System.out.println(tr("November 2016",
                    "abcdefghijklmnopqrstuvwyz",
                    "ABCDEFGHIJKLMNOPQRSTUVWYZ"));
        System.out.println(tr("abcXYZ","aZcX","||Cx"));
        
    }
}
