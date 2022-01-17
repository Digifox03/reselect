package it.digifox03.reselect.minecraft.functions

import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function
import net.minecraft.entity.passive.TropicalFishEntity

object TropicalFishVariant : Function {
	val function = "tropical_fish_variant" to this

	val variants = listOf(
		"kob", "sunstreak", "snooper",
		"dasher", "brinely", "spotty",
		"flopper", "stripey", "glitter",
		"blockfish", "betty", "clayfish"
	)

	private class TropicalFishVariantExpression(
		val str: Expression
	): Expression {
		override val type: String = "string"
		override fun value(): String {
			val variant = (str.value() as TropicalFishEntity).variant
			return variants[(variant shr 8 and 0xFF) + 6 * (variant and 0x1)]
		}
	}

	override fun make(expr: List<Expression>): Expression {
		val fish = expr.component1()
		require(fish.type == "tropical_fish")
		return TropicalFishVariantExpression(fish)
	}
}