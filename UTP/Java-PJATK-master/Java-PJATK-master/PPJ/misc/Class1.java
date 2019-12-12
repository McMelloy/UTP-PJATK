import pkg.*;
public class Class1{     
    public static void main (String[] args) {

        RecIter RecIter = new RecIter();
        System.out.println(RecIter.fiboR(45));
        System.out.println(RecIter.fiboI(45));
        System.out.println(RecIter.factR(10));
        System.out.println(RecIter.factI(10));
        System.out.println(RecIter.gcdR(12125,40643));
        System.out.println(RecIter.gcdI(12125,40643));
        int[] a = {3,8,2,9,7};
        System.out.println(RecIter.maxElem(a,0,a.length));
        RecIter.reverse(a,0,a.length);
        for (int i = 0; i < a.length; ++i)
            System.out.print(a[i] + " ");
        System.out.println();
        System.out.print("Is 'radar' a palindrom? ");
        System.out.println(RecIter.isPalindrom("radar"));
        System.out.print("Is 'rover' a palindrom? ");
        System.out.println(RecIter.isPalindrom("rover"));
    }
} 