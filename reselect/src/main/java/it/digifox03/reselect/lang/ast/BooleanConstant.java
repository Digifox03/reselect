package it.digifox03.reselect.lang.ast;

public record BooleanConstant(boolean value) implements AbstractSyntaxTree {
    @Override
    public String toString() {
        return Boolean.toString(value);
    }
}
