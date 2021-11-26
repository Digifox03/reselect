package it.digifox03.reselect.lang.instances

import it.digifox03.reselect.lang.core.Instance
import it.digifox03.reselect.lang.typeclasses.SeedableTC

object SeedableInteger: SeedableTC<Long>, Instance {
	override fun register() =
		SeedableTC.reg.register("integer", this)
	override fun seed(obj: Long): Long = obj
}
