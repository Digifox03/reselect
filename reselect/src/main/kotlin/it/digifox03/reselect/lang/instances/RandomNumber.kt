package it.digifox03.reselect.lang.instances

import it.digifox03.reselect.lang.core.Instance
import it.digifox03.reselect.lang.typeclasses.NumericTC
import it.digifox03.reselect.lang.typeclasses.RandomTC
import kotlin.random.Random

object RandomNumber: RandomTC<Double>, Instance {
	override fun register() = RandomTC.reg.register("number", this)
	override fun rand(random: Random, from: Double, to: Double) =
		random.nextDouble(from, to)
}
