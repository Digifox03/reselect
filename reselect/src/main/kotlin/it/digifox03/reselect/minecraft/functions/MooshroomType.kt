package it.digifox03.reselect.minecraft.functions

import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function
import net.minecraft.entity.passive.MooshroomEntity

object MooshroomType : Function {
	val function = "mooshroom_type" to this

	val types = listOf(
		"red", "brown"
	)

	private class MooshroomTypeExpression(
		val str: Expression
	): Expression {
		override val type: String = "string"
		override fun value(): String {
			val id = (str.value() as MooshroomEntity).mooshroomType.ordinal
			return types[id]
		}
	}

	override fun make(expr: List<Expression>): Expression {
		val mooshroom = expr.component1()
		require(mooshroom.type == "mooshroom")
		return MooshroomTypeExpression(mooshroom)
	}
}
