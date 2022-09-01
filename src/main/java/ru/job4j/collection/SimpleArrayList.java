package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;

    private int size = 0;

    private int modCount = 0;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    private void grow(int contLength) {
        container = Arrays.copyOf(container, container.length * 2);
    }

    @Override
    public void add(T value) {
        if (size >= container.length) {
            grow(container.length + 1);
        }
        container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        T deletedEl = get(index);
        container[index] = newValue;
        modCount++;
        return deletedEl;
    }

    @Override
    public T remove(int index) {
        T deletedEl = get(index);
        size--;
        if (size > index) {
            System.arraycopy(container, index + 1, container, index, size - index);
        }
        container[size] = null;
        modCount++;
        return deletedEl;
    }

    @Override
    public T get(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int cursor;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return cursor != size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[cursor++];
            }
        };
    }
}