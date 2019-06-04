package com.company.ShutingYard;


import java.util.HashMap;
import com.company.ShutingYard.ShuntingYard.Operator;

final class ShuntingYard$1 extends HashMap<String, Operator> {
    ShuntingYard$1() {
        this.put("+", Operator.ADD);
        this.put("-", Operator.SUBTRACT);
        this.put("*", Operator.MULTIPLY);
        this.put("/", Operator.DIVIDE);
        this.put("^", Operator.POW);
        this.put("sin", Operator.SIN);
    }
}
