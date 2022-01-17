package it.digifox03.reselect.minecraft.functions

import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function
import net.minecraft.entity.passive.TropicalFishEntity

object TropicalFishBase : Function {
	val function = "tropical_fish_base_color" to this

	private class TropicalFishVariantExpression(
		val str: Expression
	): Expression {
		override val type: String = "string"
		override fun value(): String {
			val variant = (str.value() as TropicalFishEntity).variant
			return TropicalFishEntity.getBaseDyeColor(variant).getName()
		}
	}

	override fun make(expr: List<Expression>): Expression {
		val fish = expr.component1()
		require(fish.type == "tropical_fish")
		return TropicalFishVariantExpression(fish)
	}
}