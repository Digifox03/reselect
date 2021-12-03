package it.digifox03.reselect.lang

import it.digifox03.reselect.lang.core.Function
import it.digifox03.reselect.lang.functions.*
import it.digifox03.reselect.lang.instances.*
import it.digifox03.reselect.lang.typeclasses.*
import it.digifox03.reselect.minecraft.instances.EntityEntity
import it.digifox03.reselect.minecraft.instances.LivingEntityLivingEntity
import it.digifox03.reselect.minecraft.instances.SeedableEntity
import it.digifox03.reselect.minecraft.typeclasses.EntityTC
import it.digifox03.reselect.minecraft.typeclasses.LivingEntityTC

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
		LivingEntityTC.func,
		NumericTC.func,
		OrderedTC.func,
		RandomTC.func,
		SeedableTC.func
	).reduce(Map<String, Function>::plus)
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
	tc + f
}
