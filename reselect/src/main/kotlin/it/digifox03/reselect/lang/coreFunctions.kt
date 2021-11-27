package it.digifox03.reselect.lang

import it.digifox03.reselect.lang.core.Function
import it.digifox03.reselect.lang.functions.*
import it.digifox03.reselect.lang.instances.*
import it.digifox03.reselect.lang.typeclasses.*

val coreFunctions: Map<String, Function> by lazy {
	listOf(
		EqualityString, EqualityBoolean,
		NumericInteger, NumericNumber,
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
		AndFunction.function,
		ContainsFunction.function,
		IfFunction.function,
		LowercaseFunction.function,
		MatchesFunction.function,
		NotFunction.function,
		OrFunction.function,
		RandFunction.function,
	)
	tc.reduce(Map<String, Function>::plus) + f
}
