public class Main {
    public static void main(String[] args) {
        try {
            throw new Exception("WHAT THE FUCK");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
