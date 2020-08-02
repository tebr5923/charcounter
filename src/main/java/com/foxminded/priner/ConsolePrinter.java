package com.foxminded.priner;

import com.foxminded.storage.Storage;

public class ConsolePrinter implements Printer {
    @SuppressWarnings("squid:S106")
    @Override
    public void print(Storage<?> storage) {
        System.out.println(storage.getInputSting());
        storage.getCountResult().forEach((k, v) -> System.out.println("\"" + k + "\" - " + v));
    }
}
