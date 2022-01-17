package it.digifox03.reselect.minecraft.functions

import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function
import net.minecraft.entity.passive.CatEntity

object CatType : Function {
	val function = "cat_type" to this

	val types = listOf(
		"tabby",
		"tuxedo",
		"red",
		"siamese",
		"british_shorthair",
		"calico",
		"persian",
		"ragdoll",
		"white",
		"jellie",
		"black"
	)

	private class CatVariantExpression(
		val str: Expression
	): Expression {
		override val type: String = "string"
		override fun value(): String {
			return (str.value() as CatEntity).catType.let { types[it] }
		}
	}

	override fun make(expr: List<Expression>): Expression {
		val cat = expr.component1()
		require(cat.type == "cat")
		return CatVariantExpression(cat)
	}
}
