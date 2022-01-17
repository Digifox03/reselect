package it.digifox03.reselect.minecraft.functions

import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function
import net.minecraft.entity.mob.ShulkerEntity

object ShulkerColor : Function {
	val function = "shulker_color" to this

	private class ShulkerColorExpression(
		val str: Expression
	): Expression {
		override val type: String = "string"
		override fun value(): String {
			return (str.value() as ShulkerEntity).color?.getName() ?: "default"
		}
	}

	override fun make(expr: List<Expression>): Expression {
		val shulker = expr.component1()
		require(shulker.type == "shulker")
		return ShulkerColorExpression(shulker)
	}
}
