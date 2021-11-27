package it.digifox03.reselect.lang.functions

import it.digifox03.reselect.lang.core.ConstExpr
import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function

object LowercaseFunction : Function {
	val function = "lowercase" to this

	private class StringExpression(
		val str: Expression
	): Expression {
		override val type: String = "string"
		override fun value(): String {
			return (str.value() as String).lowercase()
		}
	}

	override fun make(expr: List<Expression>): Expression {
		val string = expr.component1()
		require(string.type == "string")
		if (string is ConstExpr) {
			val res = (string.value() as String).lowercase()
			return ConstExpr("string", res)
		}
		return StringExpression(string)
	}
}
