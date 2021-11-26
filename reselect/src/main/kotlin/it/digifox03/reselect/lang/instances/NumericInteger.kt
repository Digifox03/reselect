package it.digifox03.reselect.lang.instances

import it.digifox03.reselect.lang.core.Instance
import it.digifox03.reselect.lang.typeclasses.NumericTC

object NumericInteger: NumericTC<Long>, Instance {
	override fun register() = NumericTC.reg.register("integer", this)
	override fun eq(a: Long, b: Long)  = a == b
	override fun ne(a: Long, b: Long)  = a != b
	override fun le(a: Long, b: Long)  = a <= b
	override fun ge(a: Long, b: Long)  = a >= b
	override fun lt(a: Long, b: Long)  = a < b
	override fun gt(a: Long, b: Long)  = a > b
	override fun add(a: Long, b: Long) = a + b
	override fun sub(a: Long, b: Long) = a - b
	override fun mul(a: Long, b: Long) = a * b
	override fun div(a: Long, b: Long) = a / b
	override fun minus(a: Long) = -a
	override fun plus(a: Long) = +a
}
