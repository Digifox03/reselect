package it.digifox03.reselect.lang.ast;

public final class DecimalConstant extends AbstractSyntaxTree {
    public final double value;

    public DecimalConstant(double value) {
        this.value = value;
    }
}
