import java.io.FileNotFoundException;

public class Excep {
    public static void main (String[] args){
        try{
            raiseArrayIndexOutOfBoundException();
            raiseFileNotFoundException();
            raiseException();
        }  catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        } catch(FileNotFoundException ex){
            System.out.println(ex);
        } catch (Exception ex1){
            System.out.println("wrong unit");
        }
    }

    public static void raiseArrayIndexOutOfBoundException() throws ArrayIndexOutOfBoundsException{
        throw new ArrayIndexOutOfBoundsException();
    }

    public static void raiseFileNotFoundException() throws FileNotFoundException{
        throw new FileNotFoundException();
    }

    

    public static void raiseException() throws Exception{
        throw new Exception(); 
    }
}