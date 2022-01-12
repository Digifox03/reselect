package it.digifox03.reselect.minecraft.typeclasses

import it.digifox03.reselect.lang.core.TypeClassRegister
import it.digifox03.reselect.lang.core.poly1

interface LivingEntityTC<T> {
	companion object {
		val reg = TypeClassRegister<LivingEntityTC<Any>, LivingEntityTC<*>>(
			name="LivingEntity"
		)
		val func = mapOf(
			"isbaby" to poly1(reg, "boolean", LivingEntityTC<Any>::isBaby),
			"health" to poly1(reg, "number", LivingEntityTC<Any>::health)
		)
	}
	fun isBaby(entity: T): Boolean
	fun health(entity: T): Double
}
