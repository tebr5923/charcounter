package com.foxminded.counter;

import java.util.LinkedHashMap;
import java.util.Map;

public class CachedCharCounter implements Counter<Character> {
    private static final int MAX_ENTRIES = 10;
    private final Map<String, Map<Character, Integer>> cachedMap;
    private final Counter<Character> charCounter;

    public CachedCharCounter(Counter<Character> charCounter) {
        this(charCounter, MAX_ENTRIES);
    }

    public CachedCharCounter(Counter<Character> charCounter, int maxEntries) {
        this.cachedMap = new LinkedHashMap<String, Map<Character, Integer>>
                (maxEntries + 1, .75F, true) {
            @Override
            public boolean removeEldestEntry(Map.Entry eldest) {
                return size() > maxEntries;
            }
        };
        this.charCounter = charCounter;
    }

    @Override
    public Map<Character, Integer> count(String inputString) {
        return cachedMap.computeIfAbsent(inputString, (String value) -> charCounter.count(inputString));
    }
}
