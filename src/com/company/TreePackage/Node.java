package com.company.TreePackage;

public class Node<E> {
    private String value;
    private Node leftSon;
    private Node rightSon;
    private Node father;
    private boolean swaped;

    Node() {
    this.swaped=false;
    }

    Node(String value, E leftSon, E rightSon, E father) {
        this.value = value;
        this.leftSon = (Node) leftSon;
        this.rightSon = (Node) rightSon;
        this.father = (Node) father;
        this.swaped=false;
    }

    Node(String value, E leftSon, E rightSon, E father, boolean bl) {
        this.value = value;
        this.leftSon = (Node) leftSon;
        this.rightSon = (Node) rightSon;
        this.father = (Node) father;
        this.swaped = bl;
    }

    void setLeftSon(Node node) {
        this.leftSon = node;
    }

    void setRightSon(Node node) {
        this.rightSon = node;
    }

    void setFather(Node node) {
        this.father = node;
    }

    Node getLeftSon() {
        return this.leftSon;
    }

    public Node getRightSon() {
        return this.rightSon;
    }

    Node getFather() {
        return this.father;
    }

    String getValue() {
        return this.value;
    }

    public boolean isLeaf(Node node) {
        if (node.leftSon == null && node.rightSon == null) {
            return true;
        } else return false;
    }

    public void setVisited() {
        this.swaped = true;
    }

    public boolean isSwaped() {
        if (!this.swaped) {
            return false;
        } else return true;
    }
    public void setSwaped(){
        this.swaped=true;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isRightSon(Node node) {
        if (node.getFather().getRightSon() == node) {
            return true;
        } else
            return false;
    }

    public boolean isLeftSon(Node node) {
        if (node.getFather().getLeftSon() == node) {
            return true;
        } else
            return false;
    }

    public boolean isHaveFather(Node node) {
        return node.getFather() != null;
    }

    public int nodeSize(Node node) {
        int size = 0;
        if (node.getLeftSon() == null) {
            return 0;
        } else {
            while (node.getLeftSon() != null) {
                node = node.getLeftSon();
                size++;
            }
        }
        return size;
    }
}
