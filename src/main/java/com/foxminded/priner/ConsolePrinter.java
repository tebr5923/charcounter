package com.foxminded.priner;

import java.util.Map;

public class ConsolePrinter implements Printer {
    @SuppressWarnings("squid:S106")
    @Override
    public void print(String string, Map<?, Long> map) {
        System.out.println(string);
        map.forEach((k, v) -> System.out.println("\"" + k + "\" - " + v));
    }
}
