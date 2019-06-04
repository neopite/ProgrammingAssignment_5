package com.company.ShutingYard;


public class QueueArray {
    private int first = 0;
    private int last = 0;
    public int size;
    private String[] queue;
    public int lastElemPop;

    public QueueArray(int size) {
        this.queue =new String[size];
        this.size = size;
    }

    public void add(String elem) {
        if (this.last == this.queue.length) {
            this.resize(this.size * 2);
        }

        this.queue[this.last] = elem;
        ++this.last;
    }

    public String pop() {
        if (!this.isEmpty()) {
            String elem = this.queue[this.first];
            queue[this.first]=null;
            lastElemPop=first;
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
            String elem = (String) var1[var3];
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
        String[] new_arr = new String [new_size];

        for(int i = 0; i < this.queue.length; ++i) {
            new_arr[i] = this.queue[i];
        }

        this.queue = new_arr;
    }

    public int getSize() {
        return this.size;
    }
    public String peek(int index){
        return queue[index];
    }

    public static void main(java.lang.String[] args) {

        QueueArray q = new QueueArray(3);
        q.add("1");
        q.add("2");
        q.add("3");
        System.out.println(q.peek(q.size-1));
        q.print();
    }
}
