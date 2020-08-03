package com.foxminded.storage;

import java.util.Map;
import java.util.Objects;

public class CharStorage implements Storage<Character> {
    private final String inputString;
    private final Map<Character, Long> countResult;

    public CharStorage(String inputString, Map<Character, Long> countResult) {
        this.inputString = inputString;
        this.countResult = countResult;
    }

    @Override
    public Map<Character, Long> getCountResult() {
        return countResult;
    }

    @Override
    public String getInputSting() {
        return inputString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharStorage that = (CharStorage) o;
        return countResult.equals(that.countResult) &&
                inputString.equals(that.inputString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countResult, inputString);
    }
}
