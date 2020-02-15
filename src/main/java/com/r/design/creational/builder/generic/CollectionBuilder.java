package com.r.design.creational.builder.generic;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Consumer;


public class CollectionBuilder<T> {
    private Collection<T> value;

    private CollectionBuilder(Collection<T> value) {
        this.value = value;
    }

    public Collection<T> build() {
        return value;
    }

    public static <T> CollectionBuilder<T> a(Collection<T> value) {
        return new CollectionBuilder<>(value);
    }

    public static <T> CollectionBuilder<T> a(
            Collection<T>  value,
            Consumer<Collection<T>> initFunc)
    {
        return new CollectionBuilder<>(value)
                .initiator(initFunc);
    }

    public CollectionBuilder<T> initiator(Consumer<Collection<T>> initiator) {
        initiator.accept(value);
        return this;
    }

    public CollectionBuilder<T> add(T t) {
        value.add(t);
        return this;
    }

    public CollectionBuilder<T> add(T t, BiConsumer<T, Builder<T>> initFunc) {
        value.add(t);
        initFunc.accept(t, Builder.a(t));
        return this;
    }
}