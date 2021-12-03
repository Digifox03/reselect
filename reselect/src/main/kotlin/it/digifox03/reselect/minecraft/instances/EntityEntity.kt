package it.digifox03.reselect.minecraft.instances

import it.digifox03.reselect.lang.core.Instance
import it.digifox03.reselect.minecraft.entities
import it.digifox03.reselect.minecraft.typeclasses.EntityTC
import net.minecraft.entity.Entity

object EntityEntity : EntityTC<Entity>, Instance {
	override fun register() = entities.forEach {
		EntityTC.reg.register(it, this)
	}
	override fun x(entity: Entity) = entity.x
	override fun y(entity: Entity) = entity.y
	override fun z(entity: Entity) = entity.z
	override fun hasName(entity: Entity) = entity.hasCustomName()
	override fun name(entity: Entity) = entity.customName!!.asString()!!
	override fun biome(entity: Entity) =
		entity.world.getBiomeKey(entity.blockPos).get().value.toString()
}
