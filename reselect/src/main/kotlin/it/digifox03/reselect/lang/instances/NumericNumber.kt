package it.digifox03.reselect.lang.instances

import it.digifox03.reselect.lang.core.Instance
import it.digifox03.reselect.lang.typeclasses.NumericTC
import it.digifox03.reselect.lang.typeclasses.OrderedTC

object NumericNumber: NumericTC<Double>, OrderedTC<Double>, Instance {
	override fun register() = NumericTC.reg.register("number", this)
	override fun eq(a: Double, b: Double)  = a == b
	override fun ne(a: Double, b: Double)  = a != b
	override fun le(a: Double, b: Double)  = a <= b
	override fun ge(a: Double, b: Double)  = a >= b
	override fun lt(a: Double, b: Double)  = a < b
	override fun gt(a: Double, b: Double)  = a > b
	override fun add(a: Double, b: Double) = a + b
	override fun sub(a: Double, b: Double) = a - b
	override fun mul(a: Double, b: Double) = a * b
	override fun div(a: Double, b: Double) = a / b
	override fun minus(a: Double) = -a
	override fun plus(a: Double) = +a
}
