package it.digifox03.reselect.lang.ast;

public final class Definition extends AbstractSyntaxTree {
    public final String name;
    public final String[] parameters;
    public final AbstractSyntaxTree definition;
    public final AbstractSyntaxTree expression;

    public Definition(
            String name,
            String[] parameters,
            AbstractSyntaxTree definition,
            AbstractSyntaxTree expression
    ) {
        this.name = name;
        this.parameters = parameters;
        this.definition = definition;
        this.expression = expression;
    }
}
