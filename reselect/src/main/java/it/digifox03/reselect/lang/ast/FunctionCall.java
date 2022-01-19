package it.digifox03.reselect.lang.ast;

public final class FunctionCall extends AbstractSyntaxTree {
    public final String name;
    public final AbstractSyntaxTree[] arguments;

    public FunctionCall(String name, AbstractSyntaxTree[] arguments) {
        this.name = name;
        this.arguments = arguments;
    }
}
