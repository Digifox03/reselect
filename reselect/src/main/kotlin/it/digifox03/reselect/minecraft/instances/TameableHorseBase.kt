package it.digifox03.reselect.minecraft.instances

import it.digifox03.reselect.lang.core.Instance
import it.digifox03.reselect.minecraft.typeclasses.TameableTC
import net.minecraft.entity.passive.HorseBaseEntity

object TameableHorseBase: TameableTC<HorseBaseEntity>, Instance {
	override fun register() = listOf(
		"donkey",
		"horse",
		"llama",
		"mule",
		"skeleton_horse",
		"trader_llama",
		"zombie_horse"
	).forEach {
		TameableTC.reg.register(it, this)
	}
	override fun isTamed(entity: HorseBaseEntity) = entity.isTame
}
