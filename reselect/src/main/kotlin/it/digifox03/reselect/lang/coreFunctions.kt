package it.digifox03.reselect.lang

import it.digifox03.reselect.lang.core.Function
import it.digifox03.reselect.lang.instances.EqualityString
import it.digifox03.reselect.lang.core.Instance
import it.digifox03.reselect.lang.functions.IfFunction
import it.digifox03.reselect.lang.instances.NumericInteger
import it.digifox03.reselect.lang.instances.NumericNumber
import it.digifox03.reselect.lang.typeclasses.EqualityTC
import it.digifox03.reselect.lang.typeclasses.NumericTC
import it.digifox03.reselect.lang.typeclasses.OrderedTC

val coreFunctions: Map<String, Function> by lazy {
	listOf<Instance>(
		EqualityString, NumericInteger, NumericNumber
	).forEach {
		it.register()
	}
	val tc = listOf(
		EqualityTC.func,
		OrderedTC.func,
		NumericTC.func,
	)
	val f = mapOf(
		IfFunction.function,
	)
	tc.reduce(Map<String, Function>::plus) + f
}
