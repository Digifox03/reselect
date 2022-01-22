package it.digifox03.reselect.lang.ast;

public record Definition(
        String name,
        String[] parameters,
        AbstractSyntaxTree definition,
        AbstractSyntaxTree expression
) implements AbstractSyntaxTree {
    @Override
    public String toString() {
        if (parameters.length == 0) {
            return String.format("let %s := %s in %s",
                    name, definition, expression
            );
        } else {
            return String.format("let %s(%s) := %s in %s",
                    name,
                    String.join(", ", parameters),
                    definition,
                    expression
            );
        }
    }
}
