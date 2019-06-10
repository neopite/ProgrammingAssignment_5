package com.company.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FileReader {
    static public File file;
    static HashMap<String, Double> hashMap = new HashMap<>();

    public void readFile(File file) throws FileNotFoundException {
        Scanner read = new Scanner(new java.io.FileReader(file));
        while (read.hasNextLine()) {
            initializationVariable(read.nextLine());
        }
    }

    public void initializationVariable(String str) {
        String[] array = str.split(" ");
        if (array[1].equalsIgnoreCase("=")) {
            hashMap.put(array[0], Double.parseDouble(array[2]));
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String line="if(a>b)?(a=a+b):(b=b-a);";
        FileReader fileReader=new FileReader();
        System.out.println(fileReader.readCondition(line));
        System.out.println(fileReader.readTrue(line));
        System.out.println(fileReader.readFalse(line));
    }
    public HashMap<String, Double> returnHashMap(){
        return this.hashMap;
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
