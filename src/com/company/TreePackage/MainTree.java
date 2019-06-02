package com.company.TreePackage;

import com.company.QueueArray;
import com.company.ShuntingYard;
import com.company.StackArray;

import java.util.Scanner;

public class MainTree {
    public static void main(String[] args) {
        String str;
        if (args.length == 0) {
            str = (new Scanner(System.in)).nextLine();
        } else {
            str = args[0];
        }

        QueueArray tokens = ShuntingYard.toPostfix(str);
        StackArray s = new StackArray(tokens.getSize());
        Tree tree=new Tree(tokens);
        tree.createTree();
        System.out.println(tree.topNode.getRightSon().getRightSon().getRightSon().getLeftSon().getValue());

    }
}
