package it.digifox03.reselect.minecraft.instances

import it.digifox03.reselect.lang.core.Instance
import it.digifox03.reselect.minecraft.typeclasses.CollaredTC
import net.minecraft.entity.passive.CatEntity

object CollaredCat: CollaredTC<CatEntity>, Instance {
	override fun register() = CollaredTC.reg.register("cat", this)
	override fun collar(entity: CatEntity): String {
		return entity.collarColor.getName()
	}
}
