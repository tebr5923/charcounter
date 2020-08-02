package com.foxminded.counter;

import com.foxminded.storage.Storage;

public abstract class AbstractCharCounter implements Counter<Character> {
    @Override
    public Storage<Character> count(String inputString) {
        checkInputString(inputString);
        return countChars(inputString);
    }

    private void checkInputString(String string) {
        if (string == null) {
            throw new IllegalArgumentException("null can't be counted");
        }
        if (string.equals("")) {
            throw new IllegalArgumentException("String is empty, can't be counted");
        }
    }

    protected abstract Storage<Character> countChars(String string);
}
