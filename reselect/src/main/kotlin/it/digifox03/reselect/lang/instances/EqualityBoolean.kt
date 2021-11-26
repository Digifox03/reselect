package it.digifox03.reselect.lang.instances

import it.digifox03.reselect.lang.core.Instance
import it.digifox03.reselect.lang.typeclasses.EqualityTC

object EqualityBoolean: EqualityTC<Boolean>, Instance {
	override fun register() = EqualityTC.reg.register("boolean", this)
	override fun eq(a: Boolean, b: Boolean) = a == b
	override fun ne(a: Boolean, b: Boolean) = a != b
}
