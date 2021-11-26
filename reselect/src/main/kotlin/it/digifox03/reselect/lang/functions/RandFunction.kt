package it.digifox03.reselect.lang.functions

import it.digifox03.reselect.lang.core.ConstExpr
import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.Function
import it.digifox03.reselect.lang.typeclasses.RandomTC
import it.digifox03.reselect.lang.typeclasses.SeedableTC
import kotlin.random.Random

object RandFunction: Function {
	val function = "rand" to this

	private class RandExpression(
		val rtc: RandomTC<Any>,
		val seed: Expression,
		val min: Expression,
		val max: Expression
	): Expression {
		override val type = "integer"
		override fun value(): Any {
			val rand = Random(seed.value() as Long)
			return rtc.rand(rand, min.value(), max.value())
		}
	}

	override fun make(expr: List<Expression>): Expression {
		val seed = expr.component1()
		val min = expr.component2()
		val max = expr.component3()
		require(min.type == max.type)
		val seedValue = SeedableTC.seed.make(listOf(seed))
		val rtc = requireNotNull(RandomTC.reg.getInstance(min.type))
		if (seedValue is ConstExpr && min is ConstExpr && max is ConstExpr) {
			val rand = Random(seed.value() as Long)
			return ConstExpr(min.type, rtc.rand(rand, min.value(), max.value()))
		}
		return RandExpression(rtc, seedValue, min, max)
	}
}
