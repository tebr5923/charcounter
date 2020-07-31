package com.foxminded.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapBuilder<T> {
    private final LinkedHashMap<T, Long> hashMap;

    public HashMapBuilder() {
        this.hashMap = new LinkedHashMap<>();
    }

    public HashMapBuilder<T> add(T var, long count) {
        hashMap.put(var, count);
        return this;
    }

    public Map<T, Long> build() {
        return hashMap;
    }
}
