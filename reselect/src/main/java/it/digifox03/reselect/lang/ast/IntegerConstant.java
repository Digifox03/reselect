package it.digifox03.reselect.lang.ast;

public final class IntegerConstant extends AbstractSyntaxTree {
    public final long value;

    public IntegerConstant(long value) {
        this.value = value;
    }
}
