package it.digifox03.reselect.test

import net.minecraft.client.texture.TextureManager
import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.util.Identifier

lateinit var overrides: Map<EntityType<*>, OverrideExpr>

fun redirect(e: LivingEntity, default: Identifier): Identifier {
	return try {
		val override = overrides[e.type] ?: return default
		override.call(e, default)
	} catch (e: RuntimeException) {
		e.printStackTrace()
		TextureManager.MISSING_IDENTIFIER
	}
}
