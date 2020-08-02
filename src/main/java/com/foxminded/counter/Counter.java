package com.foxminded.counter;

import com.foxminded.storage.Storage;

@FunctionalInterface
public interface Counter<T> {
    Storage<T> count(String inputString);
}
