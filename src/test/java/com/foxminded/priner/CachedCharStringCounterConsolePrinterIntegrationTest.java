package com.foxminded.priner;

import com.foxminded.counter.CachedCharStringCounter;
import com.foxminded.counter.CharStringCounter;
import com.foxminded.counter.StringCounter;
import com.foxminded.counter.StreamCharStringCounter;
import com.foxminded.util.LineStringJoiner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CachedCharStringCounterConsolePrinterIntegrationTest extends SystemOutTest {
    private static Stream<Arguments> generator() {
        return Stream.of(
                Arguments.of(new CharStringCounter()),
                Arguments.of(new StreamCharStringCounter()));
    }

    @ParameterizedTest
    @MethodSource("generator")
    void printCachedCharCounter_shouldPrintCorrectResultToSystemOut(StringCounter<Character> charStringCounter) {
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
        performPrint(inputString, charStringCounter);

        assertEquals(expected.toString(), getOutputAsString());
    }

    protected void performPrint(String inputString, StringCounter<Character> charStringCounter) {
        StringCounter<Character> stringCounter = new CachedCharStringCounter(charStringCounter);
        Printer printer = new ConsolePrinter();
        printer.print(stringCounter.count(inputString));
    }
}
