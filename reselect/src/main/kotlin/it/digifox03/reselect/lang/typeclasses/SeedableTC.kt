package it.digifox03.reselect.lang.typeclasses

import it.digifox03.reselect.lang.core.TypeClassRegister
import it.digifox03.reselect.lang.core.poly1

interface SeedableTC<T> {
	companion object {
		val reg = TypeClassRegister<SeedableTC<Any>, SeedableTC<*>>(
			name="Seedable"
		)
		val seed = poly1(reg, "integer", SeedableTC<Any>::seed)
		val func = mapOf(
			"seed" to seed
		)
	}
	fun seed(obj: T): Long
}
