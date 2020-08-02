package com.foxminded.priner;

import com.foxminded.storage.Storage;

@FunctionalInterface
public interface Printer {
    void print(Storage<?> storage);
}
