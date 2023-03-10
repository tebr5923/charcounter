package com.foxminded.priner;

import com.foxminded.storage.CharStorage;
import com.foxminded.util.HashMapBuilder;
import com.foxminded.util.LineStringJoiner;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsolePrinterTest extends SystemOutTest {
    @Test
    void print_shouldPrintCorrectResultToSystemOut() {
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
        Map<Character, Long> map = new HashMapBuilder<Character>()
                .add('H', 1)
                .add('e', 1)
                .add('l', 3)
                .add('o', 2)
                .add(' ', 1)
                .add('W', 1)
                .add('r', 1)
                .add('d', 1)
                .add('!', 3)
                .build();
        Printer printer = new ConsolePrinter();
        printer.print(new CharStorage(inputString, map));

        assertEquals(expected.toString(), getOutputAsString());
    }
}
