package it.digifox03.reselect.lang.instances

import it.digifox03.reselect.lang.core.Instance
import it.digifox03.reselect.lang.typeclasses.NumericTC
import it.digifox03.reselect.lang.typeclasses.RandomTC
import kotlin.random.Random
import kotlin.random.nextLong

object RandomInteger: RandomTC<Long>, Instance {
	override fun register() = RandomTC.reg.register("integer", this)
	override fun rand(random: Random, from: Long, to: Long) =
		random.nextLong(from..to)
}
