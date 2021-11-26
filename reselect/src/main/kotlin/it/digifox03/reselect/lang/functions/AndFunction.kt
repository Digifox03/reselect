package it.digifox03.reselect.lang.functions

import it.digifox03.reselect.lang.core.ConstExpr
import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function

object AndFunction: Function {
	val function = "and" to this

	private class AndExpression(
		val a: Expression, val b: Expression,
	): Expression {
		override val type = "boolean"
		override fun value(): Any =
			(a.value() as Boolean) && (b.value() as Boolean)
	}
	override fun make(expr: List<Expression>): Expression {
		val a = expr.component1()
		val b = expr.component2()
		if (a is ConstExpr && b is ConstExpr)
			return ConstExpr(
				"boolean",
				a.value() as Boolean && b.value() as Boolean
			)
		return AndExpression(a, b)
	}
}
