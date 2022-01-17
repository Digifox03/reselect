package it.digifox03.reselect.minecraft.functions

import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function
import net.minecraft.entity.passive.RabbitEntity

object RabbitVariant: Function {
	val function = "rabbit_variant" to this

	val variants = listOf(
		"brown",
		"white",
		"black",
		"black_and_white",
		"gold",
		"salt_and_pepper"
	)

	private class RabbitVariantExpression(
		val str: Expression
	): Expression {
		override val type: String = "string"
		override fun value(): String {
			val type = (str.value() as RabbitEntity).rabbitType
			if (type == 99)
				return "the_killer_bunny"
			return variants[type]
		}
	}

	override fun make(expr: List<Expression>): Expression {
		val rabbit = expr.component1()
		require(rabbit.type == "sheep")
		return RabbitVariantExpression(rabbit)
	}
}