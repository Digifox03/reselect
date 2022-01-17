package it.digifox03.reselect.minecraft.functions

import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function
import net.minecraft.entity.passive.ParrotEntity

object ParrotVariant : Function {
	val function = "parrot_variant" to this

	val variant = listOf(
		"red", "blue", "green", "cyan", "gray"
	)

	private class ParrotVariantExpression(
		val str: Expression
	): Expression {
		override val type: String = "string"
		override fun value(): String {
			return (str.value() as ParrotEntity).variant.let { variant[it] }
		}
	}

	override fun make(expr: List<Expression>): Expression {
		val parrot = expr.component1()
		require(parrot.type == "parrot")
		return ParrotVariantExpression(parrot)
	}
}
