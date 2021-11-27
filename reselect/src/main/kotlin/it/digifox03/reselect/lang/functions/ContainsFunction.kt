package it.digifox03.reselect.lang.functions

import it.digifox03.reselect.lang.core.ConstExpr
import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function

object ContainsFunction : Function {
	val function = "contains" to this

	private class ContainsExpression(
		val haystack: Expression, val needle: Expression
	): Expression {
		override val type: String = "boolean"
		override fun value(): Boolean {
			return (haystack.value() as String)
				.contains(needle.value() as String)
		}
	}

	override fun make(expr: List<Expression>): Expression {
		val haystack = expr.component1()
		val needle = expr.component2()
		require(haystack.type == "string")
		require(needle.type == "string")
		if (haystack is ConstExpr && needle is ConstExpr) {
			val res = (haystack.value() as String)
				.contains(needle.value() as String)
			return ConstExpr("boolean", res)
		}
		return ContainsExpression(haystack, needle)
	}
}
