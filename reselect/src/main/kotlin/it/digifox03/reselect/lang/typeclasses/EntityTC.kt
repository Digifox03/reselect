package it.digifox03.reselect.lang.typeclasses

import it.digifox03.reselect.lang.core.TypeClassRegister
import it.digifox03.reselect.lang.core.poly1

interface EntityTC<T> {
	companion object {
		val reg = TypeClassRegister<EntityTC<Any>, EntityTC<*>>()
		val func = mapOf(
			"x" to poly1(reg, "boolean", EntityTC<Any>::x),
		)
	}
	fun x(entity: T): Double
	fun y(entity: T): Double
	fun z(entity: T): Double
	fun biome(entity: T): String
	fun hasName(entity: T): Boolean
	fun name(entity: T): String
}
