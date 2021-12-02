package it.digifox03.reselect.lang.typeclasses

import it.digifox03.reselect.lang.core.TypeClassRegister
import it.digifox03.reselect.lang.core.poly1

interface LivingEntityTC<T> {
	companion object {
		val reg = TypeClassRegister<LivingEntityTC<Any>, LivingEntityTC<*>>()
		val func = mapOf(
			"isbaby" to poly1(reg, "boolean", LivingEntityTC<Any>::isBaby),
		)
	}
	fun isBaby(entity: T): Boolean
	fun health(entity: T): Double
}
