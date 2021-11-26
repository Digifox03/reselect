package it.digifox03.reselect.lang.typeclasses

import it.digifox03.reselect.lang.core.TypeClassRegister
import it.digifox03.reselect.lang.core.poly1
import it.digifox03.reselect.lang.core.poly2

interface NumericTC<T>: OrderedTC<T> {
	companion object {
		val reg = TypeClassRegister<NumericTC<Any>, NumericTC<*>>(OrderedTC.reg)
		val func = mapOf(
			"+"  to poly2(reg, null, NumericTC<Any>::add),
			"-"  to poly2(reg, null, NumericTC<Any>::sub),
			"*"  to poly2(reg, null, NumericTC<Any>::mul),
			"/"  to poly2(reg, null, NumericTC<Any>::div),
			"u-" to poly1(reg, null, NumericTC<Any>::minus),
			"u+" to poly1(reg, null, NumericTC<Any>::plus),
		)
	}
	fun add(a: T, b: T): T
	fun sub(a: T, b: T): T
	fun mul(a: T, b: T): T
	fun div(a: T, b: T): T
	fun minus(a: T): T
	fun plus(a: T): T
}
