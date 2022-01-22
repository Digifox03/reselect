package it.digifox03.reselect.lang.ast;

public record DecimalConstant(double value) implements AbstractSyntaxTree {
    @Override
    public String toString() {
        return Double.toString(value);
    }
}
