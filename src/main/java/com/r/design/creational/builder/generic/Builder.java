package com.r.design.creational.builder.generic;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Builder<T> {
    private T value;

    private Builder(T value) {
        this.value = value;
    }

    public T build() {
        return value;
    }

    public static <T> Builder<T> a(T value) {
        return new Builder<>(value);
    }

    public static <T> Builder<T> a(T value, Consumer<T> initiator) {
        return new Builder<>(value)
                .initiator(initiator);
    }

    public Builder<T> initiator(Consumer<T> initiator) {
        initiator.accept(value);
        return this;
    }

    public <V> Builder<T> with(BiConsumer<T, V> setter, V v) {
        setter.accept(value, v);
        return this;
    }

    public <V> Builder<T> with(BiConsumer<T, V> setter, V v, BiConsumer<V, Builder<V>> initFunc) {
        setter.accept(value, v);
        initFunc.accept(v, Builder.a(v));
        return this;
    }

    public <V> Builder<T> with(
            BiConsumer<T, Collection<V>> setter,
            Collection<V> v,
            Consumer<CollectionBuilder<V>> initFunc)
    {
        setter.accept(value, v);
        initFunc.accept(CollectionBuilder.a(v));
        return this;
    }

    public <V> Builder<T> with(
            BiConsumer<T, List<V>> setter,
            List<V> v,
            BiConsumer<List<V>, CollectionBuilder<V>> initFunc)
    {
        setter.accept(value, v);
        initFunc.accept(v, CollectionBuilder.a(v));
        return this;
    }

    public <K, V> Builder<T> with(
            BiConsumer<T, Map<K, V>> setter,
            Map<K, V> v,
            BiConsumer<Map<K, V>, MapBuilder<K, V>> initFunc)
    {
        setter.accept(value, v);
        initFunc.accept(v, MapBuilder.a(v));
        return this;
    }
}
