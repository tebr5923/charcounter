package com.foxminded.storage;

import java.util.Map;

public interface Storage<T, V> {
    Map<T, Long> getCountResult();

    V getInputValue();
}
