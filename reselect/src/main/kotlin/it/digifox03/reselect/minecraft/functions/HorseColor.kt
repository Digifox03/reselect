package it.digifox03.reselect.minecraft.functions

import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function
import net.minecraft.entity.passive.HorseEntity

object HorseColor : Function {
	val function = "horse_color" to this

	val colors = listOf(
		"white",
		"creamy",
		"chestnut",
		"brown",
		"black",
		"gray",
		"dark_brown"
	)

	private class HorseColorExpression(
		val str: Expression
	): Expression {
		override val type: String = "string"
		override fun value(): String {
			return colors[(str.value() as HorseEntity).color.index]
		}
	}

	override fun make(expr: List<Expression>): Expression {
		val horse = expr.component1()
		require(horse.type == "horse")
		return HorseColorExpression(horse)
	}
}
