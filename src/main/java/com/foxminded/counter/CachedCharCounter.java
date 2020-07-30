package com.foxminded.counter;

import java.util.LinkedHashMap;
import java.util.Map;

public class CachedCharCounter implements Counter<Character> {
    private final int MAX_ENTRIES;
    private final Map<String, Map<Character, Integer>> cachedMap;
    private final Counter<Character> charCounter;

    public CachedCharCounter(Counter<Character> charCounter) {
        this(charCounter, 10);
    }

    public CachedCharCounter(Counter<Character> charCounter, int maxEntries) {
        this.MAX_ENTRIES = maxEntries;
        this.cachedMap = new LinkedHashMap<String, Map<Character, Integer>>
                (MAX_ENTRIES + 1, .75F, true) {
            @Override
            public boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_ENTRIES;
            }
        };
        this.charCounter = charCounter;
    }

    @Override
    public Map<Character, Integer> count(String inputString) {
        return cachedMap.computeIfAbsent(inputString, (String value) -> charCounter.count(inputString));
    }
}
