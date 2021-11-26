package it.digifox03.reselect.lang

import it.digifox03.reselect.lang.ast.PrimitiveBoolean
import it.digifox03.reselect.lang.ast.PrimitiveInteger
import it.digifox03.reselect.lang.ast.PrimitiveNumber
import it.digifox03.reselect.lang.ast.PrimitiveString
import it.digifox03.reselect.lang.core.ConstExpr
import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function
import it.digifox03.reselect.lang.ast.ExpressionTree as Et

fun Et.toEvalTree(functions: Map<String, Function>) = expr2eval(functions, expr)

private fun expr2eval(
	functions: Map<String, Function>,
	expr: Et.Expr,
): Expression {
	return when (expr) {
		is Et.Function -> {
			val func = functions[expr.name] ?: error("no function ${expr.name}")
			func.make(expr.params.map { expr2eval(functions, it) })
		}
		is Et.Primitive -> when (val p = expr.primitive) {
			is PrimitiveBoolean -> ConstExpr("boolean", p.boolean)
			is PrimitiveInteger -> ConstExpr("integer", p.integer)
			is PrimitiveNumber -> ConstExpr("number", p.number)
			is PrimitiveString -> ConstExpr("string", p.string)
		}
	}
}
