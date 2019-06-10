package com.company.TreePackage;

import com.company.ShutingYard.QueueArray;
import com.company.ShutingYard.ShuntingYard;
import com.company.ShutingYard.StackArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainTree {
    public static void main(String[] args) throws FileNotFoundException {

        String str;
        if (args.length == 0) {
            str = (new Scanner(System.in)).nextLine();
        } else {
            str = args[0];
        }

        QueueArray tokens = ShuntingYard.toPostfix(str);
        StackArray s = new StackArray(tokens.getSize());
        Tree tree = new Tree();
        tree.createASTWithCondition(new File("txt"));
    }
}
