package it.digifox03.reselect.lang.typeclasses

import it.digifox03.reselect.lang.core.Function
import it.digifox03.reselect.lang.core.TypeClassRegister
import kotlin.random.Random

interface RandomTC<T> {
	companion object {
		val reg = TypeClassRegister<RandomTC<Any>, RandomTC<*>>()
		val func = mapOf<String, Function>()
	}
	fun rand(random: Random, from: T, to: T): T
}
