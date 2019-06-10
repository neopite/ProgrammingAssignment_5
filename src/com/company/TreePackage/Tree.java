package com.company.TreePackage;

import com.company.ShutingYard.*;
import java.util.Stack;

public class Tree {

    public Node createTree(QueueArray queueArray) {
        Node generalNode = new Node();
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

                if (node.nodeSize(node) > node1.nodeSize(node1)) {
                    if (elem.equalsIgnoreCase("-") || elem.equalsIgnoreCase("/")) {
                        Node father = new Node(elem, node, node1, null, true);
                        node1.setFather(father);
                        node.setFather(father);
                        father.setLeftSon(node);
                        father.setRightSon(node1);
                        stack.push(father);
                    } else {
                        Node father = new Node(elem, node, node1, null);
                        node1.setFather(father);
                        node.setFather(father);
                        father.setLeftSon(node);
                        father.setRightSon(node1);
                        stack.push(father);
                    }
                } else if (node.nodeSize(node) <= node1.nodeSize(node1)) {
                    Node father = new Node(elem, node1, node, null);
                    father.setLeftSon(node1);
                    father.setRightSon(node);
                    node1.setFather(father);
                    node.setFather(father);
                    stack.push(father);
                }
            }
        }
        System.out.println(stack.isEmpty());
        return stack.pop();
    }

    public String bypass(Node node) { //в параметр передаёться дерево(Дерево-Нода)
        Node newNode = new Node();
        Node cur = node.getLeftSon();
        Node endResult = new Node();
        while (true) {
            node = node.getLeftSon();
            if (StringParser.isDigit(node.getLeftSon().getValue())) {
                cur = node;
                break;
            }
        }
        while (true) {
            if (!StringParser.isDigit(cur.getLeftSon().getValue())) {
                cur = cur.getLeftSon();
            } else if (!StringParser.isDigit(cur.getRightSon().getValue())) {
                cur = cur.getRightSon();
            }
            if ((StringParser.isDigit(cur.getRightSon().getValue()) && StringParser.isDigit(cur.getLeftSon().getValue()))) {
                System.out.println("CUr is swap   " + cur.isSwaped());
                if (cur.isSwaped()) {
                    System.out.println(cur.getRightSon().getValue() + cur.getValue() + cur.getLeftSon().getValue());
                    String result = calculateNode((cur.getRightSon().getValue() + cur.getValue() + cur.getLeftSon().getValue()));
                    newNode = new Node(Integer.toString((int) Double.parseDouble(result)), null, null, null);
                    endResult = newNode;
                } else if(!cur.isSwaped()) {
                    System.out.println(cur.getLeftSon().getValue() + cur.getValue() + cur.getRightSon().getValue());
                    String result = calculateNode((cur.getLeftSon().getValue() + cur.getValue() + cur.getRightSon().getValue()));
                    newNode = new Node(Integer.toString((int) Double.parseDouble(result)), null, null, null);
                    endResult = newNode;
                }
                if (cur.getFather() == null) {
                    break;
                }
                if (cur.isLeftSon(cur)) {
                    cur = cur.getFather();
                    cur.setLeftSon(newNode);
                    newNode.setFather(cur);
                } else {
                    cur = cur.getFather();
                    cur.setRightSon(newNode);
                    newNode.setFather(cur);

                }
            }
        }
        return endResult.getValue();
    }

    public String calculateNode(String str) {
        QueueArray tokens = ShuntingYard.toPostfix(str);
        StackArray s = new StackArray(tokens.getSize());

        while (!tokens.isEmpty()) {
            System.out.print("Stack: ");
            s.printArray();
            System.out.print("Queue: ");
            tokens.print();
            String elem = (String) tokens.pop();
            System.out.println(elem);
            if (StringParser.isDigit(elem)) {
                s.push(elem);
            } else if (elem.equals("!")) {
                s.push(String.valueOf(Double.parseDouble((String) s.pop()) * -1.0D));
            } else if (elem.equals("sin")) {
                s.push(String.valueOf(Math.sin(Double.parseDouble((String) s.pop()))));
            } else {
                double a = Double.parseDouble((String) s.pop());
                double b = Double.parseDouble((String) s.pop());
                s.push(String.valueOf(Operators.calculate(b, a, elem)));
            }
        }
        return ((String) s.peek());
    }
}


