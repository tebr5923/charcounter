package com.foxminded.counter;

import java.util.HashMap;
import java.util.Map;

public class CachedCharCounter implements Counter<Character> {
    private final Map<String, Map<Character, Integer>> cachedMap;
    private final Counter<Character> charCounter;

    public CachedCharCounter(Counter<Character> charCounter) {
        this.cachedMap = new HashMap<>();
        this.charCounter = charCounter;
    }

    @Override
    public Map<Character, Integer> count(String inputString) {
        cachedMap.computeIfAbsent(inputString, (String value) -> charCounter.count(inputString));
        return cachedMap.get(inputString);
    }
}
