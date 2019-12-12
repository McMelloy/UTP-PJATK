import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Landline_phone l = new Landline_phone();
        Console c = new Console();
        Mobile_phone m = new Mobile_phone();
        Smartphone s = new Smartphone();
        Device[] o = {l , c, m, s };
        
        
        System.out.println("Landline_phone: " + l.can_call());

        m.putSim();
        System.out.println("Mobile phone can call: " + m.can_call() +" can text: " + m.can_text());

        c.connect();
        System.out.println("Console can play: " + c.can_play() + "  has internet: " + c.has_internet());

        s.connect();
        s.putSim();
        System.out.println("Smarthone can call: " + s.can_call() + " can play: " + s.can_play() + 
        " can tex: " + s.can_text() + " has internet: " + s.has_internet());

        ArrayList<Object> canCall = new ArrayList();
       
        for(Device a: o){
            
            if(a.can_call()){
                canCall.add(a);
            }
        }

       // System.out.println(canCall.toString());     
        
    } 

    

}