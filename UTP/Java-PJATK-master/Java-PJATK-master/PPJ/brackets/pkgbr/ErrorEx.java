package pkgbr;
public class ErrorEx extends Exception {
    public String msg;
    public ErrorEx(int lines, char in , char tmp){
        System.out.println("ERROR in line " + lines +" "+ "'"+in+"'" + " found, but "+"'"+ tmp+  "' expected.");
    }
}

