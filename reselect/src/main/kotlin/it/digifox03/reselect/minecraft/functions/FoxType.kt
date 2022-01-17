package it.digifox03.reselect.minecraft.functions

import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function
import net.minecraft.entity.passive.FoxEntity

object FoxType : Function {
	val function = "fox_type" to this

	private class FoxVariantExpression(
		val str: Expression
	): Expression {
		override val type: String = "string"
		override fun value(): String {
			return (str.value() as FoxEntity).foxType.key
		}
	}

	override fun make(expr: List<Expression>): Expression {
		val fox = expr.component1()
		require(fox.type == "fox")
		return FoxVariantExpression(fox)
	}
}
