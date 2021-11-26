package it.digifox03.reselect.lang.functions

import it.digifox03.reselect.lang.core.ConstExpr
import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function

object NotFunction: Function {
	val function = "not" to this

	private class NotExpression(
		val a: Expression,
	): Expression {
		override val type = "boolean"
		override fun value(): Any = !(a.value() as Boolean)
	}
	override fun make(expr: List<Expression>): Expression {
		val a = expr.component1()
		if (a is ConstExpr)
			return ConstExpr("boolean", !(a.value() as Boolean))
		return NotExpression(a)
	}
}
