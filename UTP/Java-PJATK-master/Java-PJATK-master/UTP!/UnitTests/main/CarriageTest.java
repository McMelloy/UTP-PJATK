package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class CarriageTest {

    final static int NUMBER = 135;
    Carriage c1;

    @BeforeEach
    public void before() {
        c1 = new Carriage(NUMBER);
        assertEquals(NUMBER, c1.getNumberOfSeats());
    }

    @Test
    void aggregate() {
        Integer value1 = null;
        int aggr = c1.aggregate(value1);
        assertEquals(NUMBER, aggr);
        final int value2 = 13 + NUMBER;
        int aggr2 =c1.aggregate(13);
        assertEquals(value2, aggr2);
    }

    @Test
    void deepClone() {
        Carriage clone = c1.deepClone();
        assertEquals(c1.getNumberOfSeats(), clone.getNumberOfSeats());
        assertNotSame(c1, clone);
    }
}