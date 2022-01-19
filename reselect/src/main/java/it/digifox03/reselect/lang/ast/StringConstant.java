package it.digifox03.reselect.lang.ast;

public final class StringConstant extends AbstractSyntaxTree {
    public final String value;

    public StringConstant(String value) {
        this.value = value;
    }
}
