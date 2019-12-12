public class Manual extends Book {
    private String device;

    public Manual(String t, int n, String a, String device) throws WrongDeviceException {
        super(t, n, a);
        if (device.length() < 3){
            throw new WrongDeviceException("Wrong device");
        } else {
            this.device = device; 
            

        }
    }

    @Override 
    public String toString(){
        return super.toString() + " " + device;
    }
}