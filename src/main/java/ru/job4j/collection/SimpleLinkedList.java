package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements LinkedList<E> {

    private int size = 0;

    private int modCount = 0;

    transient Node<E> head;

    transient Node<E> tail;

    @Override
    public void add(E value) {
        final Node<E> newNode = new Node<>(value, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            modCount++;
            return;
        }
        Node<E> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = newNode;
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> current = head;
        int count = 0;
        while (count != index) {
            current = current.next;
            count++;
        }
        return current.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> cursor = head;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return cursor != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> itemReturn = cursor;
                cursor = cursor.next;
                return itemReturn.item;
            }
        };
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}