package it.digifox03.reselect.lang.typeclasses

import it.digifox03.reselect.lang.core.TypeClassRegister
import it.digifox03.reselect.lang.core.poly2

interface OrderedTC<T>: EqualityTC<T> {
	companion object {
		val reg = TypeClassRegister<OrderedTC<Any>, OrderedTC<*>>(EqualityTC.reg)
		val func = mapOf(
			"<"  to poly2(reg, "boolean", OrderedTC<Any>::lt),
			">"  to poly2(reg, "boolean", OrderedTC<Any>::gt),
			"<=" to poly2(reg, "boolean", OrderedTC<Any>::le),
			">=" to poly2(reg, "boolean", OrderedTC<Any>::ge),
		)
	}
	fun lt(a: T, b: T): Boolean
	fun le(a: T, b: T) = lt(a, b) || eq(a, b)
	fun gt(a: T, b: T) = !le(a, b)
	fun ge(a: T, b: T) = !lt(a, b)
}