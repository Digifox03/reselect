package it.digifox03.reselect.minecraft.functions

import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function
import net.minecraft.entity.passive.PandaEntity

object PandaGene: Function {
	val function = "panda_gene" to this

	private class PandaGeneTypeExpression(
		val str: Expression
	): Expression {
		override val type: String = "string"
		override fun value(): String {
			return (str.value() as PandaEntity).productGene.getName()
		}
	}

	override fun make(expr: List<Expression>): Expression {
		val panda = expr.component1()
		require(panda.type == "panda")
		return PandaGeneTypeExpression(panda)
	}
}