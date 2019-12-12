public class Main {
    public static void main(String[] args) {
        
    Singer s1 = new Singer("Johnson") { 
        @Override
        public String sing() {
            return "oooooooooooo";
        }
    };

    Singer s2 = new Singer("Bon Jovi") {
        @Override
        public String sing() {
            return "a4iBBiii";
        }
    };

    Singer s3 = new Singer("Dio"){ 
        @Override
        public String sing() {
            return "aAa";
        }   
    };

    Singer sp[] = {s1, s2, s3}; 
    for (Singer s : sp)
        System.out.println(s); 

    System.out.println("\n"+ Singer.loudest(sp));
    }
}