package com.foxminded.integration;

import com.foxminded.counter.CachedCharCounter;
import com.foxminded.counter.CharCounter;
import com.foxminded.counter.Counter;
import com.foxminded.priner.ConsolePrinter;
import com.foxminded.priner.Printer;
import com.foxminded.util.LineStringJoiner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CachedCharCounterConsolePrinterTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(null);
    }

    @Test
    void printCachedCharCounter_shouldPrintCorrectResultToSystemOut() {
        LineStringJoiner expected = new LineStringJoiner()
                .add("Hello World!!!")
                .add("\"H\" - 1")
                .add("\"e\" - 1")
                .add("\"l\" - 3")
                .add("\"o\" - 2")
                .add("\" \" - 1")
                .add("\"W\" - 1")
                .add("\"r\" - 1")
                .add("\"d\" - 1")
                .add("\"!\" - 3");

        String inputString = "Hello World!!!";
        performPrint(inputString);

        assertEquals(expected.toString(), getOutputAsString());
    }

    protected void performPrint(String inputString) {
        Counter<Character> counter = new CachedCharCounter(new CharCounter());
        Printer printer = new ConsolePrinter();
        printer.print(counter.count(inputString));
    }

    protected String getOutputAsString() {
        return output.toString();
    }
}
