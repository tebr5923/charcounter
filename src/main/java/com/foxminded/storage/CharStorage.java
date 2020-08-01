package com.foxminded.storage;

import java.util.Map;

public class CharStorage implements Storage<Character> {
    private final Map<Character, Long> countResult;
    private final String inputString;

    public CharStorage(String inputString, Map<Character, Long> countResult) {
        this.countResult = countResult;
        this.inputString = inputString;
    }

    @Override
    public Map<Character, Long> getCountResult() {
        return countResult;
    }

    @Override
    public String getInputSting() {
        return inputString;
    }
}
