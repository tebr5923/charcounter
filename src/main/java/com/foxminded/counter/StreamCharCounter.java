package com.foxminded.counter;

import com.foxminded.storage.CharStorage;
import com.foxminded.storage.Storage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamCharCounter extends AbstractCharCounter {
    @Override
    protected Storage<Character, String> countChars(String string) {
        Map<Character, Long> map;
        map = string.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        return new CharStorage(string, map);
    }
}
