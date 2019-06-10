package com.company.FileReader;

import jdk.jfr.events.FileReadEvent;

import java.util.ArrayList;

public class ConditionParser {
    public static String condition;
    public static String sign;
    public static String beforeSign;
    public static String afterSign;
    static ArrayList<String> arrayListOfSigns;
    FileReader fileReader;

    public ConditionParser(String str) {
        this.condition = str;
        fileReader = new FileReader();
    }

    ConditionParser() {

    }

    public String wholeCondiotion() {
        char[] chars = condition.toCharArray();
        for (int itter = 0; itter < chars.length - 1; itter++) {
            if (arrayListOfSigns.contains(condition.substring(itter, itter + 1))) {
                beforeSign = condition.substring(0, itter);
                afterSign = condition.substring(itter + 1, chars.length);
                sign=condition.substring(itter, itter + 1);
                return sign;
            }
        }
        return null;
    }
    public String getBeforeSign(){
        return beforeSign;
    }
    public String getAfterSign(){
        return afterSign;
    }
    public String getSign(){
        return sign;
    }

    public static void main(String[] args) {
        ConditionParser conditionParser = new ConditionParser("a+b>c");
        conditionParser.initializationSigns();
        System.out.println(conditionParser.wholeCondiotion());
        System.out.println(conditionParser.afterSign);
        System.out.println(conditionParser.beforeSign);
    }

    public void initializationSigns() {
        arrayListOfSigns = new ArrayList<>();
        arrayListOfSigns.add("==");
        arrayListOfSigns.add(">=");
        arrayListOfSigns.add("!=");
        arrayListOfSigns.add("<=");
        arrayListOfSigns.add("<");
        arrayListOfSigns.add(">");
    }
}
