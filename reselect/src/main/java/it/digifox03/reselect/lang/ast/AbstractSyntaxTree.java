package it.digifox03.reselect.lang.ast;

public sealed interface AbstractSyntaxTree permits
        BooleanConstant, DecimalConstant, Definition, FunctionCall,
        IntegerConstant, StringConstant {
}
