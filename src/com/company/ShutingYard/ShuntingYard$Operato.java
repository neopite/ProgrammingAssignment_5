package com.company.ShutingYard;

enum ShuntingYard$Operato {
    ADD(1),
    SUBTRACT(2),
    MULTIPLY(3),
    DIVIDE(4),
    POW(5),
    SIN(6);

    final int precedence;

    private ShuntingYard$Operato(int p) {
        this.precedence = p;
    }
}
