package it.digifox03.reselect.lang.ast;

public final class BooleanConstant extends AbstractSyntaxTree {
    public final boolean value;

    public BooleanConstant(boolean value) {
        this.value = value;
    }
}
