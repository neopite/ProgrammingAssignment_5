package com.company.TreePackage;

import com.company.FileReader.ConditionParser;
import com.company.FileReader.FileReader;
import com.company.ShutingYard.QueueArray;
import com.company.ShutingYard.ShuntingYard;
import com.company.ShutingYard.StackArray;
import com.company.ShutingYard.StringParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class MainTree {
    public static void main(String[] args) throws FileNotFoundException {

      /*  String str;
        if (args.length == 0) {
            str = (new Scanner(System.in)).nextLine();
        } else {
            str = args[0];
        }
        */

        Tree tree = new Tree();
        FileReader fileReader = new FileReader("txt");
        fileReader.readFileAndReturnCondition();
        Node node = tree.createASTWithCondition("txt");
        ConditionParser conditionParser = new ConditionParser(fileReader.readCondition(fileReader.readFileAndReturnCondition()));
        conditionParser.initializationSigns();
        conditionParser.wholeCondiotion();
        System.out.println(tree.calculateASTWithLetters(node, fileReader, conditionParser));

    }
}
