package it.digifox03.reselect.lang.functions

import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function
import it.digifox03.reselect.lang.typeclasses.RandomTC
import it.digifox03.reselect.lang.typeclasses.SeedableTC
import kotlin.random.Random

object RandFunction: Function {
	val function = "rand" to this

	private class RandExpression(
		val stc: SeedableTC<Any>,
		val rtc: RandomTC<Any>,
		val seed: Expression,
		val min: Expression,
		val max: Expression
	): Expression {
		override val type = "integer"
		override fun value(): Any {
			val rand = Random(stc.seed(seed.value()))
			return rtc.rand(rand, min.value(), max.value())
		}
	}

	override fun make(expr: List<Expression>): Expression {
		val seed = expr.component1()
		val min = expr.component2()
		val max = expr.component3()
		require(min.type == max.type)
		val rtc = requireNotNull(RandomTC.reg.getInstance(min.type))
		val stc = requireNotNull(SeedableTC.reg.getInstance(seed.type))
		return RandExpression(stc, rtc, seed, min, max)
	}
}
