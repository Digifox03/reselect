package it.digifox03.reselect.lang.instances

import it.digifox03.reselect.lang.core.Instance
import it.digifox03.reselect.lang.typeclasses.EqualityTC

object EqualityString: EqualityTC<String>, Instance {
	override fun register() = EqualityTC.reg.register("string", this)
	override fun eq(a: String, b: String) = a == b
}
