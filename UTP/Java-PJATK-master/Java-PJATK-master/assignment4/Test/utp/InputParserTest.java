package utp;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    void parse() {
        System.out.println(InputParser.parse(new File("/Users/alice/Coding/Java/assignment4/src/utp/people.txt")).toString());
    }
}