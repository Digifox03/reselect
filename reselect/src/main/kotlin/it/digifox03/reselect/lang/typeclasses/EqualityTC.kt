package it.digifox03.reselect.lang.typeclasses

import it.digifox03.reselect.lang.core.TypeClassRegister
import it.digifox03.reselect.lang.core.poly2

interface EqualityTC<T> {
	companion object {
		val reg = TypeClassRegister<EqualityTC<Any>, EqualityTC<*>>()
		val func = mapOf(
			"==" to poly2(reg, "boolean", EqualityTC<Any>::eq),
		)
	}
	fun eq(a: T, b: T): Boolean
}
