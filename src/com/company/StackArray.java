package com.company;

public class StackArray<E> {
    private int top = -1;
    private E[] arr;
    private int size;

    public StackArray(int size) {
        this.size = size;
        this.arr = (E[]) new Object[size];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == this.size - 1;
    }

    public void push(E element) {
        if (this.isFull()) {
            this.resize(this.size * 2);
        }

        ++this.top;
        this.arr[this.top] = element;
    }

    public E pop() {
        if (!this.isEmpty()) {
            E elem = this.arr[this.top];
            --this.top;
            return elem;
        } else {
            return null;
        }
    }

    public E peek() {
        return !this.isEmpty() ? this.arr[this.top] : null;
    }

    public int getSize() {
        return this.size;
    }

    private void resize(int new_size) {
        this.size = new_size;
        E[] temp = (E[]) new Object[new_size];

        for(int i = 0; i < this.arr.length; ++i) {
            temp[i] = this.arr[i];
        }

        this.arr = temp;
    }

    public void clear() {
        this.top = -1;
    }
}
