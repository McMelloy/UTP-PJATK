public class Task_6 {
    public static void main(String[] args) {
        
        try {
            Book k1 = new Book("Title_1", 45, "Anonymous");
            Book k2 = new Book();
            Book k3 = new Manual("Tytul_2", 34, "Anna Nowak" , "Printer"); 
            Book k4 = new Manual("Tytul_3", 23, " Kowalski", "DVD");
            
            /*System.out.println(k1);
            System.out.println(k2);
            System.out.println(k3);
            System.out.println(k4);
            */
            Book[] arr = {k1, k2, k3};
            for (Book k : arr) System.out.println(k);
        } catch(WrongDeviceException e){
            System.out.println(e);
        }
        
    }
}