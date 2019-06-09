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
        FileReader fileReader = new FileReader();
        fileReader.readFile(new File("/home/yarik/IdeaProjects/IntroToProg5Lab/src/com/company/FileReader/txt"));
    }
    public HashMap<String, Double> returnHashMap(){
        return this.hashMap;
    }
}
