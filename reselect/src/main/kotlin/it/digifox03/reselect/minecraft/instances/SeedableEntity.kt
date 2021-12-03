package it.digifox03.reselect.minecraft.instances

import it.digifox03.reselect.lang.core.Instance
import it.digifox03.reselect.lang.typeclasses.SeedableTC
import it.digifox03.reselect.minecraft.entities
import it.digifox03.reselect.minecraft.livingEntities
import it.digifox03.reselect.minecraft.typeclasses.LivingEntityTC
import net.minecraft.entity.Entity

object SeedableEntity: SeedableTC<Entity>, Instance {
	override fun register() = entities.forEach {
		SeedableTC.reg.register(it, this)
	}
	override fun seed(obj: Entity): Long = obj.uuid.mostSignificantBits
}
