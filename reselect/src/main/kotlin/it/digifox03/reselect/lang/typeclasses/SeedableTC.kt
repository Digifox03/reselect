package it.digifox03.reselect.lang.typeclasses

import it.digifox03.reselect.lang.core.TypeClassRegister
import it.digifox03.reselect.lang.core.poly1

interface SeedableTC<T> {
	companion object {
		val reg = TypeClassRegister<SeedableTC<Any>, SeedableTC<*>>()
		val func = mapOf(
			"seed" to poly1(reg, "integer", SeedableTC<Any>::seed)
		)
	}
	fun seed(obj: T): Long
}
