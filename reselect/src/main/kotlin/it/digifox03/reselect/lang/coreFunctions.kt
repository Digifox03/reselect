package it.digifox03.reselect.lang

import it.digifox03.reselect.lang.core.Function
import it.digifox03.reselect.lang.core.Instance
import it.digifox03.reselect.lang.functions.IfFunction
import it.digifox03.reselect.lang.functions.RandFunction
import it.digifox03.reselect.lang.instances.*
import it.digifox03.reselect.lang.typeclasses.*

val coreFunctions: Map<String, Function> by lazy {
	listOf(
		EqualityString, NumericInteger, NumericNumber,
		RandomInteger, RandomNumber,
		SeedableInteger, SeedableString
	).forEach {
		it.register()
	}
	val tc = listOf(
		EqualityTC.func,
		NumericTC.func,
		OrderedTC.func,
		RandomTC.func,
		SeedableTC.func
	)
	val f = mapOf(
		IfFunction.function,
		RandFunction.function,
	)
	tc.reduce(Map<String, Function>::plus) + f
}
