package it.digifox03.reselect.minecraft.instances

import it.digifox03.reselect.lang.core.Instance
import it.digifox03.reselect.minecraft.typeclasses.CollaredTC
import net.minecraft.entity.passive.WolfEntity

object CollaredWolf: CollaredTC<WolfEntity>, Instance {
	override fun register() = CollaredTC.reg.register("wolf", this)
	override fun collar(entity: WolfEntity): String {
		return entity.collarColor.getName()
	}
}
