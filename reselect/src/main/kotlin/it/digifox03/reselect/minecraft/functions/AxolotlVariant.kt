package it.digifox03.reselect.minecraft.functions

import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function
import net.minecraft.entity.passive.AxolotlEntity

object AxolotlVariant : Function {
	val function = "axolotl_variant" to this

	private class AxolotlVariantExpression(
		val str: Expression
	): Expression {
		override val type: String = "string"
		override fun value(): String {
			return (str.value() as AxolotlEntity).variant.getName()
		}
	}

	override fun make(expr: List<Expression>): Expression {
		val axolotl = expr.component1()
		require(axolotl.type == "axolotl")
		return AxolotlVariantExpression(axolotl)
	}
}
