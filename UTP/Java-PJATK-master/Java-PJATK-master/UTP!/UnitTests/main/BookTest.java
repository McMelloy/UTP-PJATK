package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    final int NUMBER = 135;
    Book b1;

    @BeforeEach
    public void createObject() {
        b1 = new Book(NUMBER);
        assertEquals(NUMBER, b1.returnNumberOfPages());
    }

    @Test
    void aggregate() {
        Integer value1 = null;
        assertEquals(NUMBER, b1.aggregate(value1));
        final int value2 = 13 + NUMBER;
        assertEquals(value2, b1.aggregate(13));
    }

    @Test
    void deepClone() {
        Book clone = b1.deepClone();
        assertEquals(b1.returnNumberOfPages(), clone.returnNumberOfPages());
        assertNotSame(b1, clone);
    }

}