package com.company.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FileReader {
    static public File file;
    static HashMap<String, Double> hashMap = new HashMap<>();

    public FileReader(String file){
        this.file=new File("/home/yarik/IdeaProjects/IntroToProg5Lab/src/com/company/FileReader/"+file);
    }
   public FileReader(){

   }

    public String readFileAndReturnCondition() throws FileNotFoundException {
        Scanner read = new Scanner(new java.io.FileReader(file));
        String condition="";
        while (read.hasNextLine()) {
            String line=read.nextLine();
            if(isCondition(line)){
                condition=line;
            }else {
                initializationVariable(line);
            }
        }
        return condition;
    }

    public void initializationVariable(String str) {
        String[] array = str.split(" ");
        if (array[1].equalsIgnoreCase("=")) {
            hashMap.put(array[0], Double.parseDouble(array[2]));
        }
    }
    public HashMap<String, Double> returnHashMap(){
        return this.hashMap;
    }
    public boolean isCondition(String line){
        char[] chars=line.toCharArray();
        String ln="";
        ln+=chars[0];
        ln+=chars[1];
        if(ln.equalsIgnoreCase("if")){
            return true;
        }
        else return false;
    }
    public String readCondition(String line){
        int first=0;
        int last=0;
        char [] chars = line.toCharArray();
        for (int itter = 0; itter < chars.length; itter++) {
            if(chars[itter] == '('){
                first=itter;
            }
            if(chars[itter] == '?'){
                last=itter;
                break;
            }
        }
        String str=line.substring(first+1,last-1);
        return str;
    }
    public String readTrue(String line){
        int first=0;
        int last=0;
        char [ ] chars=line.toCharArray();
        for (int itter = 0; itter < chars.length; itter++) {
            if(chars[itter]=='?'){
                first=itter+2;
            }
            if(chars[itter]==':'){
                last=itter-1;
            }

        }
        return line.substring(first,last);
    }
    public String readFalse(String str){
        int first=0;
        int last=0;
        char [] chars=str.toCharArray();
        for (int itter = 0; itter < chars.length; itter++) {
            if(chars[itter]==':'){
                first=itter+2;
            }
            if(chars[itter]==';'){
                last=itter-1;
            }
        }
        return str.substring(first,last);
    }


}
