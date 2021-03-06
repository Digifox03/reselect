package it.digifox03.reselect.minecraft.typeclasses

import it.digifox03.reselect.lang.core.TypeClassRegister
import it.digifox03.reselect.lang.core.poly1

interface EntityTC<T> {
	companion object {
		val reg = TypeClassRegister<EntityTC<Any>, EntityTC<*>>(
			name="Entity"
		)
		val func = mapOf(
			"x" to poly1(reg, "number", EntityTC<Any>::x),
			"y" to poly1(reg, "number", EntityTC<Any>::y),
			"z" to poly1(reg, "number", EntityTC<Any>::z),
			"current_biome" to poly1(reg, "string", EntityTC<Any>::biome),
			"has_name" to poly1(reg, "boolean", EntityTC<Any>::hasName),
			"name" to poly1(reg, "string", EntityTC<Any>::name),
		)
	}
	fun x(entity: T): Double
	fun y(entity: T): Double
	fun z(entity: T): Double
	fun biome(entity: T): String
	fun hasName(entity: T): Boolean
	fun name(entity: T): String
}
