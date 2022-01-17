package it.digifox03.reselect.minecraft.functions

import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function
import net.minecraft.entity.passive.SheepEntity

object SheepColor : Function {
	val function = "sheep_color" to this

	private class SheepColorExpression(
		val str: Expression
	): Expression {
		override val type: String = "string"
		override fun value(): String {
			return (str.value() as SheepEntity).color.getName()
		}
	}

	override fun make(expr: List<Expression>): Expression {
		val sheep = expr.component1()
		require(sheep.type == "sheep")
		return SheepColorExpression(sheep)
	}
}
