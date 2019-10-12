package a1;

import org.junit.Assert;


public class Main {
    public static void main(String[] args) {
         final int AGE = 20;
         Person _person;
         _person = new Person(AGE);
         Assert.assertEquals(AGE, _person.age());
    }
}
