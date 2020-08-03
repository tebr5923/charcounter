package com.foxminded.integration;

import com.foxminded.counter.CachedCharCounter;
import com.foxminded.counter.CharCounter;
import com.foxminded.counter.Counter;
import com.foxminded.counter.StreamCharCounter;
import com.foxminded.priner.ConsolePrinter;
import com.foxminded.priner.Printer;
import com.foxminded.util.LineStringJoiner;
import com.foxminded.util.SystemOutputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CachedCharCounterConsolePrinterIntegrationTest {
    private static Stream<Arguments> generator() {
        return Stream.of(
                Arguments.of(new CharCounter()),
                Arguments.of(new StreamCharCounter()));
    }

    private final SystemOutputStream output = new SystemOutputStream();

    @BeforeEach
    void setUp() {
        output.great();
    }

    @AfterEach
    void tearDown() {
        output.setNull();
    }

    @ParameterizedTest
    @MethodSource("generator")
    void printCachedCharCounter_shouldPrintCorrectResultToSystemOut(Counter<Character> charCounter) {
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
        performPrint(inputString, charCounter);

        assertEquals(expected.toString(), output.getOutputAsString());
    }

    protected void performPrint(String inputString, Counter<Character> charCounter) {
        Counter<Character> counter = new CachedCharCounter(charCounter);
        Printer printer = new ConsolePrinter();
        printer.print(counter.count(inputString));
    }
}
