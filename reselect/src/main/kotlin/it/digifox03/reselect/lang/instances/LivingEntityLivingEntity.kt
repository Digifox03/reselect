package it.digifox03.reselect.lang.instances

import it.digifox03.reselect.lang.typeclasses.LivingEntityTC
import net.minecraft.entity.LivingEntity

object LivingEntityLivingEntity : LivingEntityTC<LivingEntity> {
	override fun isBaby(entity: LivingEntity) = entity.isBaby
	override fun health(entity: LivingEntity) = entity.health.toDouble()
}
