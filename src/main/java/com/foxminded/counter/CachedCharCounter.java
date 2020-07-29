package com.foxminded.counter;

import java.util.LinkedHashMap;
import java.util.Map;

public class CachedCharCounter implements Counter<Character> {
    private final Map<String, Map<Character, Integer>> cachedMap;
    private final Counter<Character> charCounter;

    public CachedCharCounter(Counter<Character> charCounter) {
        final int MAX_ENTRIES = 10;
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
        cachedMap.computeIfAbsent(inputString, (String value) -> charCounter.count(inputString));
        return cachedMap.get(inputString);
    }

    public int size() {
        return cachedMap.size();
    }

    public Map<Character, Integer> getCachedCounter(String key) {
        return cachedMap.get(key);
    }

}
