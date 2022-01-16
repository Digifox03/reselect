package it.digifox03.reselect.minecraft

import it.digifox03.reselect.lang.core.Function
import it.digifox03.reselect.minecraft.instances.*
import it.digifox03.reselect.minecraft.typeclasses.CollaredTC
import it.digifox03.reselect.minecraft.typeclasses.EntityTC
import it.digifox03.reselect.minecraft.typeclasses.LivingEntityTC

val livingEntities = listOf(
	"axolotl",
	"bat",
	"bee",
	"blaze",
	"cat",
	"cave_spider",
	"chicken",
	"cod",
	"cow",
	"creeper",
	"dolphin",
	"donkey",
	"drowned",
	"elder_guardian",
	"ender_dragon",
	"enderman",
	"endermite",
	"evoker",
	"fox",
	"ghast",
	"giant",
	"glow_squid",
	"goat",
	"guardian",
	"hoglin",
	"horse",
	"husk",
	"illusioner",
	"iron_golem",
	"llama",
	"magma_cube",
	"mooshroom",
	"mule",
	"ocelot",
	"panda",
	"parrot",
	"phantom",
	"pig",
	"piglin",
	"piglin_brute",
	"pillager",
	"polar_bear",
	"pufferfish",
	"rabbit",
	"ravager",
	"salmon",
	"sheep",
	"shulker",
	"silverfish",
	"skeleton",
	"skeleton_horse",
	"slime",
	"snow_golem",
	"spider",
	"strider",
	"squid",
	"stray",
	"trader_llama",
	"tropical_fish",
	"turtle",
	"vex",
	"villager",
	"vindicator",
	"wandering_trader",
	"witch",
	"wither",
	"wither_skeleton",
	"wolf",
	"zoglin",
	"zombie",
	"zombie_horse",
	"zombie_villager",
	"zombified_piglin",
)

val entities = livingEntities

val minecraftFunctions: Map<String, Function> by lazy {
	listOf(
		CollaredCat,
		CollaredWolf,
		EntityEntity,
		LivingEntityLivingEntity,
		SeedableEntity,
	).forEach {
		it.register()
	}
	val tc = listOf(
		EntityTC.func,
		LivingEntityTC.func,
		CollaredTC.func,
	).reduce(Map<String, Function>::plus)
	val f = listOf<Pair<String, Function>>(
	)
	tc + f
}
