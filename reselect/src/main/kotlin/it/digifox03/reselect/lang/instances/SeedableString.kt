package it.digifox03.reselect.lang.instances

import it.digifox03.reselect.lang.core.Instance
import it.digifox03.reselect.lang.typeclasses.SeedableTC
import java.security.MessageDigest

object SeedableString: SeedableTC<String>, Instance {
	override fun register() = SeedableTC.reg.register("string", this)
	// TODO: maybe use a different hash
	override fun seed(obj: String): Long = obj.hashCode().toLong()
}
