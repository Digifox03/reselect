package it.digifox03.reselect.lang.ast;

public record FunctionCall(
        String name,
        AbstractSyntaxTree[] arguments
) implements AbstractSyntaxTree {
    @Override
    public String toString() {
        if (arguments.length == 0) {
            return name;
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append(name);
            builder.append("(");
            for (int i = 0; i < arguments.length; i++) {
                if (i != 0) builder.append(", ");
                builder.append(arguments[i]);
            }
            builder.append(")");
            return builder.toString();
        }
    }
}
