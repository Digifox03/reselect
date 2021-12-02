package it.digifox03.reselect.lang.instances

import it.digifox03.reselect.lang.typeclasses.SeedableTC
import net.minecraft.entity.Entity

object SeedableEntity: SeedableTC<Entity> {
	override fun seed(obj: Entity): Long = obj.uuid.mostSignificantBits
}
