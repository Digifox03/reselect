package it.digifox03.reselect.minecraft.instances

import it.digifox03.reselect.lang.core.Instance
import it.digifox03.reselect.minecraft.typeclasses.TameableTC
import net.minecraft.entity.passive.TameableEntity

object TameableTameableEntity: TameableTC<TameableEntity>, Instance {
	override fun register() = listOf("cat", "parrot", "wolf").forEach {
		TameableTC.reg.register(it, this)
	}
	override fun isTamed(entity: TameableEntity) = entity.isTamed
}
