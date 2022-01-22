package it.digifox03.reselect.lang.ast;

public record StringConstant(String value) implements AbstractSyntaxTree {
    @Override
    public String toString() {
        String res = value
                .replace("\n", "\\n")
                .replace("\t", "\\t")
                .replace("\"", "\\\"");
        return '"' + res + '"';
    }
}
