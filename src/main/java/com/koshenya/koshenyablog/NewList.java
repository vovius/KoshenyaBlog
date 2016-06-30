package com.koshenya.koshenyablog;

class NewList {
    int data;
    NewList next = null;
    NewList prev = null;

    NewList(int data) {
        this.data = data;
    }

    void appendLast(int data) {
        NewList nl = new NewList(data);
        NewList t = this;
        while (t.next != null) {
            t = t.next;
        }
        t.next = nl;
        nl.prev = t;
    }

    void deleteNode(int data) {
        NewList t = this;

        if (t.data == data) {
            /*
            t.next.prev = null;
            // змістити вершину в t.next ?????
            return;*/
            t.next.prev = t.prev;
            return;
        }

        while (t.data != data) {
            t = t.next;
        }
        if (t.next == null) {
            t.prev.next = t.next;
        } else {
            t.prev.next = t.next;
            t.next.prev = t.prev;
        }
        t = null;
    }


    void print() {
        NewList t = this;
        System.out.print(t.data + " ");
        do {
            t = t.next;
            System.out.print(t.data + " ");
        } while (t.next != null);

        System.out.print("; " + t.data + " ");
        do {
            t = t.prev;
            System.out.print(t.data + " ");
        } while (t.prev != null);
        System.out.println();
    }

    public static void main(String args[]) {
        NewList nl = new NewList(0);
        nl.appendLast(1);
        nl.appendLast(2);
        nl.appendLast(3);
        nl.appendLast(4);
        nl.appendLast(5);
        nl.appendLast(6);
        nl.appendLast(7);
        nl.appendLast(8);
        nl.appendLast(9);
        nl.appendLast(10);
        nl.print();

        nl.deleteNode(3);
        nl.print();

        nl.deleteNode(0);
        nl.print();

        nl.deleteNode(10);
        nl.print();

        nl.deleteNode(9);
        nl.print();
    }
}