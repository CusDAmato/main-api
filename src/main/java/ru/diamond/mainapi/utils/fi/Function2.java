package ru.diamond.mainapi.utils.fi;

@FunctionalInterface
public interface Function2<T, U, R> {
    R apply(T t, U u);
}
