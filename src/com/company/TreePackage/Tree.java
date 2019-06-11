package com.company.TreePackage;

import com.company.FileReader.ConditionParser;
import com.company.FileReader.FileReader;
import com.company.ShutingYard.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree {
    public int heightCounter = 0;
    public Node createTree(QueueArray queueArray) {
        Node generalNode = new Node();
        StackArray s = new StackArray(queueArray.getSize());
        Stack<Node> stack = new Stack<>();
        while (!queueArray.isEmpty()) {
            System.out.print("Queue: ");
            queueArray.print();
            String elem = (String) queueArray.pop();
            if (StringParser.isDigit(elem) || Character.isLetter(elem.charAt(0))) {
                Node node = new Node(elem, null, null, null);
                stack.push(node);
            } else {
                Node node = stack.pop();
                Node node1 = stack.pop();
                heightCounter++;

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

    public String bypass(Node node,FileReader fileReader) throws FileNotFoundException { //в параметр передаёться дерево(Дерево-Нода)
        HashMap<String,String> hashMap=fileReader.returnHashMap();
        Node newNode = new Node();
        Node cur = node.getLeftSon();
        Node endResult = new Node();
        if(node.nodeSize(node)==0){
            return hashMap.get(node.getValue());
        }
        if(node.nodeSize(node)==1){
            cur=node;
        }else {
            while (true) {
                node = node.getLeftSon();
                if (StringParser.isDigit(node.getLeftSon().getValue()) || Character.isLetter(node.getLeftSon().getValue().charAt(0))) {
                    cur = node;
                    break;
                }
            }
        }
        while (true) {
            if (!StringParser.isDigit(cur.getLeftSon().getValue()) && !Character.isLetter(cur.getLeftSon().getValue().charAt(0))) {
                cur = cur.getLeftSon();
            } else if (!StringParser.isDigit(cur.getRightSon().getValue()) && !Character.isLetter(cur.getRightSon().getValue().charAt(0))) {
                cur = cur.getRightSon();
            }
            if ((StringParser.isDigit(cur.getRightSon().getValue()) || Character.isLetter(cur.getRightSon().getValue().charAt(0))) &&
                    ((StringParser.isDigit(cur.getLeftSon().getValue())) || Character.isLetter(cur.getLeftSon().getValue().charAt(0)))) {
                if(Character.isLetter(cur.getLeftSon().getValue().charAt(0))){
                    cur.getLeftSon().setValue(hashMap.get(cur.getLeftSon().getValue()));
                }
                if(Character.isLetter(cur.getRightSon().getValue().charAt(0))){
                    cur.getRightSon().setValue(hashMap.get(cur.getRightSon().getValue()));
                }

                if (cur.isSwaped()) {
                    System.out.println(cur.getRightSon().getValue() + cur.getValue() + cur.getLeftSon().getValue());
                    String result = calculateWithLetters(cur.getRightSon().getValue() + cur.getValue() + cur.getLeftSon().getValue(),fileReader);
                    newNode = new Node(Integer.toString((int) Double.parseDouble(result)), null, null, null);
                    endResult = newNode;
                } else if(!cur.isSwaped()) {
                    System.out.println(cur.getLeftSon().getValue() + cur.getValue() + cur.getRightSon().getValue());
                    String result = calculateWithLetters((cur.getLeftSon().getValue() + cur.getValue() + cur.getRightSon().getValue()),fileReader);
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

    public String calculateNode(String str) throws FileNotFoundException {
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
    public Node createASTWithCondition(String file) throws FileNotFoundException {
        Tree tree=new Tree();
        Node root=new Node("if",null,null,null);
        FileReader fileReader=new FileReader(file);
        ConditionParser conditionParser=new ConditionParser(fileReader.readCondition(fileReader.readFileAndReturnCondition()));
        conditionParser.initializationSigns();
        conditionParser.wholeCondiotion();
        Node leftSon=new Node(conditionParser.getBeforeSign(),null,null,null);
        Node rightson=new Node(conditionParser.getAfterSign(),null,null,null);
        Node node=new Node(conditionParser.getSign(),leftSon,rightson,root);
        root.setLeftSon(node);
        QueueArray queueArray=ShuntingYard.toPostfix(fileReader.readTrue(fileReader.readFileAndReturnCondition()),fileReader);
        QueueArray queueArray1=ShuntingYard.toPostfix(fileReader.readFalse(fileReader.readFileAndReturnCondition()),fileReader);
        Node nodeL=tree.createTree(queueArray);
        Node nodeR=tree.createTree(queueArray1);
        Node rightSon=new Node("~",nodeL,nodeR,root);
        root.setRightSon(rightSon);
        return root;

    }
    public String calculateASTWithLetters(Node root,FileReader fileReader,ConditionParser conditionParser) throws FileNotFoundException {
        Tree tree=new Tree();
        Node nfwe=tree.createTree(ShuntingYard.toPostfix(conditionParser.getBeforeSign(),fileReader));
        Node nodgerg=tree.createTree(ShuntingYard.toPostfix(conditionParser.getAfterSign(),fileReader));
        System.out.println(conditionParser.getSign());
        boolean bl=conditionParser.putCondition(Integer.parseInt(tree.bypass(nfwe,fileReader)),conditionParser.getSign(),Integer.parseInt(tree.bypass(nodgerg,fileReader)));
        if(bl==true){
            System.out.println(calculateWithLetters(tree.bypass(root.getRightSon().getLeftSon(),fileReader),fileReader));
        }else{
            System.out.println(calculateWithLetters(tree.bypass(root.getRightSon().getRightSon(),fileReader),fileReader));
        }
        return "fe";
    }

    public String calculateWithLetters(String str,FileReader fl) throws FileNotFoundException {
        QueueArray tokens = ShuntingYard.toPostfix(str,fl);

        StackArray s = new StackArray(tokens.getSize());

        while (!tokens.isEmpty()) {
            System.out.print("Stack: ");
            s.printArray();
            System.out.print("Queue: ");
            tokens.print();
            String elem = (String) tokens.pop();
            if (StringParser.isDigit(elem)) {
                s.push(elem);
            }
            else if (elem.equals("!")) {
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



