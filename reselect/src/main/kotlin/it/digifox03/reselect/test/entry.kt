package it.digifox03.reselect.test

import net.fabricmc.fabric.api.resource.ResourceManagerHelper
import net.fabricmc.api.ClientModInitializer
import net.minecraft.resource.ResourceType

class ClientEntry: ClientModInitializer {
	override fun onInitializeClient() {
		ResourceManagerHelper
			.get(ResourceType.CLIENT_RESOURCES)
			.registerReloadListener(ResourceManager)
	}
}
