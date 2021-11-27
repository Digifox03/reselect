package it.digifox03.reselect.lang.functions

import it.digifox03.reselect.lang.core.ConstExpr
import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function

object MatchesFunction : Function {
	val function = "matches" to this

	private class MatchesExpression(
		val str: Expression, val regex: Regex,
	): Expression {
		override val type: String = "boolean"
		override fun value(): Boolean {
			return regex.matches(str.value() as String)
		}
	}

	override fun make(expr: List<Expression>): Expression {
		val str = expr.component1()
		val reg = expr.component2()
		require(reg is ConstExpr)
		require(str.type == "string")
		val regex = Regex(reg.value() as String)
		if (str is ConstExpr) {
			val res = regex.matches(str.value() as String)
			return ConstExpr("boolean", res)
		}
		return MatchesExpression(str, regex)
	}
}
