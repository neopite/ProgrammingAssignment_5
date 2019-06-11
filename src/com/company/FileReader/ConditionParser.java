package com.company.FileReader;

import com.company.ShutingYard.StringParser;
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

    public ConditionParser() {

    }

    public void wholeCondiotion() {
        char[] chars = condition.toCharArray();
        for (int itter = 0; itter < chars.length - 1; itter++) {
            if (arrayListOfSigns.contains(condition.substring(itter, itter + 2))) {
                beforeSign = condition.substring(0, itter);
                afterSign = condition.substring(itter + 2, chars.length);
                sign=condition.substring(itter, itter + 2);
            }
        }
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



    public void initializationSigns() {
        arrayListOfSigns = new ArrayList<>();
        arrayListOfSigns.add("==");
        arrayListOfSigns.add(">=");
        arrayListOfSigns.add("!=");
        arrayListOfSigns.add("<=");
        arrayListOfSigns.add("<<");
        arrayListOfSigns.add(">>");
    }

    public boolean putCondition(int beforeSign, String sign,int afterSign){
        if(sign.equalsIgnoreCase("==")){
            if(beforeSign==afterSign){
                return true;
            }
            else return false;
        }
        else if(sign.equalsIgnoreCase(">=")){
            if(beforeSign>=afterSign){
                return true;
            }else return false;
        }
        else if(sign.equalsIgnoreCase("!=")){
            if(beforeSign!=afterSign){
                return true;
            } else  return false;
        }
       else if(sign.equalsIgnoreCase("<=")){
            if(beforeSign<=afterSign){
                return true;
            } else return false;
        }
        else if(sign.equalsIgnoreCase("<<")){
            if(beforeSign<afterSign){
                return true;
            }else return false;
        }
       else if(sign.equalsIgnoreCase(">>")){
            if(beforeSign>afterSign){
                return true;
            }
            else return false;
        }
        System.out.println("++++++++++++++++++++");
        return false;
    }

}
