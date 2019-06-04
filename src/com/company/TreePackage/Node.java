package com.company.TreePackage;

public class Node<E> {
    private String value;
    private Node leftSon;
    private Node rightSon;
    private Node father;

    Node(String value,E leftSon,E rightSon,E father){
        this.value=value;
        this.leftSon= (Node) leftSon;
        this.rightSon= (Node) rightSon;
        this.father= (Node) father;
    }
     void setLeftSon(Node node){
        this.leftSon=node;
    }
     void setRightSon(Node node){
        this.rightSon=node;
    }
     void setFather(Node node){
        this.father=node;
    }
     Node getLeftSon(){
        return this.leftSon;
    }
     public Node getRightSon(){
        return this.rightSon;
    }
     Node getFather(){
        return this.father;
    }
    String getValue(){
        return this.value;
    }
    public boolean isLeaf(Node node){
        if(node.leftSon==null || node.rightSon==null){
            return true;
        }else return false;
    }
}
