package it.digifox03.reselect.lang.ast;

public record IntegerConstant(long value) implements AbstractSyntaxTree {
    @Override
    public String toString() {
        return Long.toString(value);
    }
}
