package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;


class ContainerTest {

    Container <Book,Integer> cont1;
    Container <Carriage,Integer> cont2;
    private final int NUMBER1 = 50;
    private final int NUMBER2 = 50;

    @BeforeEach
    void elements() {
        cont1 = new Container();
        cont2 = new Container();

        cont1.elements().add(new Book(30));
        cont1.elements().add(new Book(20));

        cont2.elements().add(new Carriage(30));
        cont2.elements().add(new Carriage(20));
    }

    @Test
    public void aggregateAllElements() {
        int aggrAll1 = cont1.aggregateAllElements();
        assertEquals(NUMBER1,aggrAll1);
        int aggrAll2 = cont2.aggregateAllElements();
        assertEquals(NUMBER2, aggrAll2);
    }

    @Test
    public void cloneElementAtIndex() {
        Book clone = cont1.cloneElementAtIndex(0);
        assertEquals(cont1.elements().get(0).returnNumberOfPages(), clone.returnNumberOfPages());
        assertNotSame(cont1, clone);
    }
}