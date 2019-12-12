abstract public class Singer{
    private static int counter = 1; 
    private String surname;
    private int number;

    public Singer(String surname) {
        this.surname = surname;
        number = counter;
        counter++;
    }
    abstract String sing();

    static Singer loudest(Singer[] s) {
        Singer loud = s[0];
        int cap = 0;
        int prev = 0;
        for(int i = 0 ; i < s.length; i++) {
            for(int j = 0; j < s[i].sing().length(); j++) {
                if(Character.isUpperCase(s[i].sing().charAt(j))){
                    cap++;
                }
            }
            if (cap > prev) {
                loud = s[i];
            }
            prev = cap;
            cap = 0;
        }   
        return loud;
    }   

    public  String toString() {
        return "(" + number + ") " + surname + " "+ sing();
    }
}