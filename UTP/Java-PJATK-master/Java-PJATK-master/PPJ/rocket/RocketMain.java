public class RocketMain{
    public static void main (String[] args){
        Rocket r = new Rocket();
        try {
            r.start();
        } catch(ComputerErrorException ex) {
            System.out.println(ex);
        }    
    }
}