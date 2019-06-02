package com.company.TreePackage;

import com.company.QueueArray;
import com.company.StackArray;
import com.company.StringParser;
import com.company.TreePackage.Node;

import java.util.ArrayList;

public class Tree {
    ArrayList<String> arrayListOfActions = new ArrayList<>();
    public QueueArray queueArray;
    Node topNode;
    Node root;
    static int itter=0;

    Tree(QueueArray queueArray) {
        this.queueArray = queueArray;
        arrayListOfActions.add("+");
        arrayListOfActions.add("/");
        arrayListOfActions.add("*");
        arrayListOfActions.add("-");
    }

    public void createTree() {
        StackArray s = new StackArray(queueArray.getSize());

        while (!queueArray.isEmpty()) {
            System.out.print("Stack: ");
            String last = "";
            s.printArray();
            System.out.print("Queue: ");
            queueArray.print();
            String elem = (String) queueArray.pop();
            int ind = this.queueArray.lastElemPop;
            System.out.println(elem);
            if (StringParser.isDigit(elem)) {
                s.push(elem);
                itter++;
            } else {
                if(itter==2) {
                    Node node = new Node(s.pop(), null, null, null);
                    Node node1 = new Node(s.pop(), null, null, null);
                    Node nod = new Node(elem, node1, node, null);
                    topNode = nod;
                    node.setFather(nod);
                    node1.setFather(nod);
                }

                 if (arrayListOfActions.contains(elem) && (is2Digits(this.queueArray.peek(ind + 1), this.queueArray.peek(ind + 2), ind))) {
                    root = new Node(this.queueArray.peek(this.queueArray.size - 1), null, null, null);
                    root.setRightSon(topNode);
                }
                 if (is1Digit(this.queueArray.peek(ind + 1), ind) && arrayListOfActions.contains(this.queueArray.peek(ind + 2)) && !arrayListOfActions.contains(last)) {
                    Node node = new Node(this.queueArray.peek(ind + 1), null, null, null);
                    Node node1 = new Node(this.queueArray.peek(ind + 2), null, null, null);
                    node1.setLeftSon(node);
                    node1.setRightSon(topNode);
                    node.setFather(node1);
                    topNode = node1;
                }
/*
                double a = Double.parseDouble((String)s.pop());
                double b = Double.parseDouble((String)s.pop());
                s.push(String.valueOf(Operators.calculate(b, a, elem)));
                */
            }
        }

        System.out.println((String) s.peek());
    }

    public boolean is2Digits(String intStr1, String intStr2, int ind) {
        try {
            int int1 = Integer.parseInt((String) intStr1);
            int int2 = Integer.parseInt((String) intStr2);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean is1Digit(String str, int ind) {
        try {
            int int1 = Integer.parseInt((String) str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

