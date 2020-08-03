package com.foxminded.counter;

import com.foxminded.storage.Storage;

@FunctionalInterface
public interface StringCounter<T> {
    Storage<T, String> count(String inputString);
}
