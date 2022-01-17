package it.digifox03.reselect.minecraft.typeclasses

import it.digifox03.reselect.lang.core.TypeClassRegister
import it.digifox03.reselect.lang.core.poly1

interface TameableTC<T> {
	companion object {
		val reg = TypeClassRegister<TameableTC<Any>, TameableTC<*>>(
			name="Tameable"
		)
		val func = mapOf(
			"is_tamed" to poly1(reg, "boolean", TameableTC<Any>::isTamed),
		)
	}
	fun isTamed(entity: T): Boolean
}
