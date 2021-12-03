package it.digifox03.reselect.minecraft.instances

import it.digifox03.reselect.lang.core.Instance
import it.digifox03.reselect.minecraft.entities
import it.digifox03.reselect.minecraft.livingEntities
import it.digifox03.reselect.minecraft.typeclasses.EntityTC
import it.digifox03.reselect.minecraft.typeclasses.LivingEntityTC
import net.minecraft.entity.LivingEntity

object LivingEntityLivingEntity : LivingEntityTC<LivingEntity>, Instance {
	override fun register() = livingEntities.forEach {
		LivingEntityTC.reg.register(it, this)
	}
	override fun isBaby(entity: LivingEntity) = entity.isBaby
	override fun health(entity: LivingEntity) = entity.health.toDouble()
}
