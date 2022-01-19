package it.digifox03.reselect.lang.ast;

public sealed class AbstractSyntaxTree permits
        BooleanConstant, DecimalConstant, Definition, FunctionCall,
        IntegerConstant, StringConstant {
}
