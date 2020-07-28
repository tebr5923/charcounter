package com.foxminded.counter;

import java.util.Map;

@FunctionalInterface
public interface Counter<T> {
    Map<T, Integer> count(String inputString);
}
