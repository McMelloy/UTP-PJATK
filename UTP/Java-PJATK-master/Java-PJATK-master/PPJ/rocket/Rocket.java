public class Rocket{
    private Computer computer1;
    private Computer computer2;
  //  private Computer comp1un;
    //private Computer comp2un;
        public Rocket(){
           computer1 = new Computer(1);
           computer2 = new Computer(10);
        }

    public void start() throws ComputerErrorException {
        System.out.println("Start engine");

        while(computer1.measure() < 10000 && computer2.measure()< 10000){
            System.out.println(computer1.alt + " " + computer2.alt);
        }

        if(computer1.alt == computer2.alt) {
            System.out.println("Shutdown engine");
        } else {
            throw new ComputerErrorException("computer mismatch alt");
        }
    }
}