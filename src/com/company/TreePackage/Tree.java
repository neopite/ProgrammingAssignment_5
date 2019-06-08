package com.company.TreePackage;

import com.company.ShutingYard.QueueArray;
import com.company.ShutingYard.StackArray;
import com.company.ShutingYard.StringParser;

import java.util.Stack;

public class Tree {
    public QueueArray queueArray;

    Tree(QueueArray queueArray) {
        this.queueArray = queueArray;

    }

    public Node createTree() {
        int frequency = 0;
        StackArray s = new StackArray(queueArray.getSize());
        Stack<Node> stack = new Stack<>();

        while (!queueArray.isEmpty()) {
            System.out.print("Queue: ");
            queueArray.print();
            String elem = (String) queueArray.pop();
            if (StringParser.isDigit(elem)) {
                Node node = new Node(elem, null, null, null);
                stack.push(node);
            } else {
                Node node = stack.pop();
                Node node1 = stack.pop();
                Node father = new Node(elem, node1, node, null);
                node1.setFather(father);
                node.setFather(father);
                stack.push(father);
            }
        }
        System.out.println(stack.isEmpty());
        return stack.pop();
    }

    public String bypass(Node node) { //в параметр передаёться дерево(Дерево-Нода)
        Node node1=node.getRightSon() ;
        while (node1.getRightSon() != null) {
            node1=node1.getLeftSon();
            System.out.println(node1.getValue());
        }
        return "True";
    }

}

