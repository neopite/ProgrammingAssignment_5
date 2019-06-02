package com.company;


public class QueueArray<E> {
    private int first = 0;
    private int last = 0;
    private int size;
    private E[] queue;

    public QueueArray(int size) {
        this.queue = (E[]) new Object[size];
        this.size = size;
    }

    public void add(E elem) {
        if (this.last == this.queue.length) {
            this.resize(this.size * 2);
        }

        this.queue[this.last] = elem;
        ++this.last;
    }

    public E pop() {
        if (!this.isEmpty()) {
            E elem = this.queue[this.first];
            ++this.first;
            return elem;
        } else {
            return null;
        }
    }

    public void print() {
        System.out.print("[ ");
        Object[] var1 = this.queue;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            E elem = (E) var1[var3];
            if (elem != null) {
                System.out.print(elem + " ");
            }
        }

        System.out.println("]");
    }

    public boolean isEmpty() {
        return this.queue[this.first] == null;
    }

    private void resize(int new_size) {
        E[] new_arr = (E[]) new Object[new_size];

        for(int i = 0; i < this.queue.length; ++i) {
            new_arr[i] = this.queue[i];
        }

        this.queue = new_arr;
    }

    public int getSize() {
        return this.size;
    }

    public static void main(String[] args) {
        QueueArray<Integer> q = new QueueArray(10);
        System.out.println(q.isEmpty());
        q.add(5);
        q.add(7);
        q.add(8);
        System.out.println(q.isEmpty());
        q.pop();
        q.pop();
        q.pop();
        System.out.println(q.isEmpty());
        q.print();
    }
}
