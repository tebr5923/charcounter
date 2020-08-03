package com.foxminded.counter;

import com.foxminded.storage.Storage;

import java.util.LinkedHashMap;
import java.util.Map;

public class CachedCharStringCounter implements StringCounter<Character> {
    private static final int MAX_ENTRIES = 10;
    private final Map<String, Storage<Character, String>> cachedMap;
    private final StringCounter<Character> charStringCounter;

    public CachedCharStringCounter(StringCounter<Character> charStringCounter) {
        this(charStringCounter, MAX_ENTRIES);
    }

    public CachedCharStringCounter(StringCounter<Character> charStringCounter, int maxEntries) {
        this.cachedMap = new LinkedHashMap<String, Storage<Character, String>>
                (maxEntries + 1, .75F, true) {
            @Override
            public boolean removeEldestEntry(Map.Entry eldest) {
                return size() > maxEntries;
            }
        };
        this.charStringCounter = charStringCounter;
    }

    @Override
    public Storage<Character, String> count(String inputString) {
        return cachedMap.computeIfAbsent(inputString, value -> charStringCounter.count(inputString));
    }
}
