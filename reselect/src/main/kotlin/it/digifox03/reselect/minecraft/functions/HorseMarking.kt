package it.digifox03.reselect.minecraft.functions

import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function
import net.minecraft.entity.passive.HorseEntity

object HorseMarking : Function {
	val function = "horse_marking" to this

	val markings = listOf(
		"none",
		"white",
		"white_field",
		"white_dots",
		"black_dots",
	)

	private class HorseMarkingExpression(
		val str: Expression
	): Expression {
		override val type: String = "string"
		override fun value(): String {
			return markings[(str.value() as HorseEntity).marking.index]
		}
	}

	override fun make(expr: List<Expression>): Expression {
		val horse = expr.component1()
		require(horse.type == "horse")
		return HorseMarkingExpression(horse)
	}
}
