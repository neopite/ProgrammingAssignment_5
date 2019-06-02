package com.company;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        String str;
        if (args.length == 0) {
            str = (new Scanner(System.in)).nextLine();
        } else {
            str = args[0];
        }

        QueueArray tokens = ShuntingYard.toPostfix(str);
        StackArray s = new StackArray(tokens.getSize());

        while(!tokens.isEmpty()) {
            System.out.print("Stack: ");
            s.printArray();
            System.out.print("Queue: ");
            tokens.print();
            String elem = (String)tokens.pop();
            System.out.println(elem);
            if (StringParser.isDigit(elem)) {
                s.push(elem);
            } else if (elem.equals("!")) {
                s.push(String.valueOf(Double.parseDouble((String)s.pop()) * -1.0D));
            } else if (elem.equals("sin")) {
                s.push(String.valueOf(Math.sin(Double.parseDouble((String)s.pop()))));
            } else {
                double a = Double.parseDouble((String)s.pop());
                double b = Double.parseDouble((String)s.pop());
                s.push(String.valueOf(Operators.calculate(b, a, elem)));
            }
        }
        System.out.println(s.currentSize);
        s.printArray();
        System.out.println((String)s.peek());
    }
}

