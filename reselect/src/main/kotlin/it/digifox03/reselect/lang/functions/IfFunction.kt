package it.digifox03.reselect.lang.functions

import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function

object IfFunction : Function {
	val function = "if" to this

	private class IfExpression(
		val cond: Expression, val bt: Expression, val be: Expression,
	): Expression {
		override val type: String = bt.type
		override fun value(): Any {
			return if (cond.value() as Boolean) {
				bt.value()
			} else {
				be.value()
			}
		}
	}

	override fun make(expr: List<Expression>): Expression {
		val cond = expr.component1()
		val bt = expr.component2()
		val be = expr.component3()
		require(bt.type == be.type)
		return IfExpression(cond, bt, be)
	}
}
