import java.util.*;

public class GCD {
  static void print(Object obj) {
    System.out.println(obj);
  }
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int m = scan.nextInt();
    int n = scan.nextInt();
    if (m == 0) {
      print(n);
    }
    else {
      while (m > 0) {
        if (m > n) {
          int temp = m;
          m = n;
          n = temp;
        }
        else if (m == n){
          print(n);
          break;
        }
        else {
          n = n-m;
        }
      }
    }
  }
}

//