package bai_tap;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public boolean add(int index, E element) {
        if (index < 0) {
            return false;
        }
        else{
            elements[index] = elements;
            size++;
            return true;
        }
    }
    public boolean add(E e) {
        elements[size++] = e;
        return true;
    }

    public void remove(int index) {
        if (index < 0 || index > elements.length) {

        } else {
            for (int e = index; e < elements.length; e++){
                elements[e] = elements[e + 1];
            }
            elements = Arrays.copyOf(elements,(elements.length-1));
            size --;
        }
    }
    public int size(){
        return size;
    }
    public void clear(){
        elements = new Object[DEFAULT_CAPACITY];
    }
    public int indexOf(E o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null)
                    return i;

            }
        } else
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i]))
                    return i;
            }

        return -1;
    }
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > size || minCapacity > DEFAULT_CAPACITY) {
            MyList<E> temp = new MyList<>(minCapacity);

            temp = clone();
            elements = new Object[minCapacity];

            for (int i = 0; i < size; i++) {
                elements[i] = temp.get(i);
            }
        }
    }
    public E get(int i) {
        return (E) elements[i];
    }

    public MyList<E> clone() {
        MyList<E> temp = new MyList<>(size);
        for (int i = 0; i < size; i++) {
            temp.add((E) elements[i]);
        }

        return temp;
    }
    public String toString() {
        StringBuilder list = new StringBuilder();
        list.append("List (size: ").append(size()).append("){");
        for (int i = 0; i < size; i++) {
            list.append(elements[i]).append(", ");
        }
        list.append("}");
        return String.valueOf(list);
    }
}
