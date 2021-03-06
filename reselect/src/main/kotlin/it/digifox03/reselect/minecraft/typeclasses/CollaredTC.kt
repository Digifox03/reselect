package it.digifox03.reselect.minecraft.typeclasses

import it.digifox03.reselect.lang.core.TypeClassRegister
import it.digifox03.reselect.lang.core.poly1

interface CollaredTC<T> {
	companion object {
		val reg = TypeClassRegister<CollaredTC<Any>, CollaredTC<*>>(
			name="Collared"
		)
		val func = mapOf(
			"collar_color" to poly1(reg, "string", CollaredTC<Any>::collar),
		)
	}
	fun collar(entity: T): String
}
