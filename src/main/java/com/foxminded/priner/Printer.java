package com.foxminded.priner;

import java.util.Map;

@FunctionalInterface
public interface Printer {
    public void print(String string, Map<?, Long> map);
}
