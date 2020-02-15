package com.r.design.creational.builder.generic;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;


public class MapBuilder<K,V> {
    private Map<K, V> value;

    private MapBuilder(Map<K, V> value) {
        this.value = value;
    }

    public Map<K, V> build() {
        return value;
    }

    public static <K, V> MapBuilder<K, V> a(Map<K, V> value) {
        return new MapBuilder<>(value);
    }

    public static <K, V> MapBuilder<K, V> a(
            Map<K, V>  value,
            Consumer<Map<K, V>> initFunc)
    {
        return new MapBuilder<>(value)
                .initiator(initFunc);
    }

    public MapBuilder<K, V> initiator(Consumer<Map<K, V>> initiator) {
        initiator.accept(value);
        return this;
    }

    public MapBuilder<K, V> put(K k, V v) {
        value.put(k, v);
        return this;
    }

    public MapBuilder<K, V> put(K k, V v, BiConsumer<V, Builder<V>> initFunc) {
        value.put(k, v);
        initFunc.accept(v, Builder.a(v));
        return this;
    }
}
