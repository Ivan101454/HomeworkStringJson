package ru.clevertec.enums;

public enum Bracket {
    CURLYOPEN("{"), CURLYCLOSE("}"), SQUAREOPEN("["), SQUARECLOSE("]");
    private String symbol;
    Bracket(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
