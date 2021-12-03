package it.digifox03.reselect.test

import com.github.h0tk3y.betterParse.grammar.parseToEnd
import it.digifox03.reselect.lang.ReselectGrammar
import it.digifox03.reselect.lang.ast.ExpressionTree
import it.digifox03.reselect.lang.toExpressionTree
import it.digifox03.reselect.minecraft.entities
import net.fabricmc.fabric.api.resource.SimpleResourceReloadListener
import net.minecraft.entity.EntityType
import net.minecraft.resource.ResourceManager
import net.minecraft.util.Identifier
import net.minecraft.util.profiler.Profiler
import java.io.IOException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor

object ResourceManager
	: SimpleResourceReloadListener<Map<String, ExpressionTree>> {
	private val grammar = ReselectGrammar()

	private val fabricId = Identifier("vmt", "entity_selector")
	override fun getFabricId() = fabricId

	override fun apply(
		data: Map<String, ExpressionTree>,
		manager: ResourceManager,
		profiler: Profiler,
		executor: Executor
	): CompletableFuture<Void> = CompletableFuture.runAsync({
		overrides = buildMap {
			for ((entity, expression) in data) {
				val type = EntityType.get(entity).get()
				set(type, OverrideExpr(entity, expression))
			}
		}
	}, executor)

	override fun load(
		manager: ResourceManager,
		profiler: Profiler,
		executor: Executor
	) = CompletableFuture.supplyAsync({
		buildMap {
			for (entity in entities) {
				val id = Identifier("vmt", "$entity.reselect")
				val resource = try {
					manager.getResource(id)
				} catch (_: IOException) {
					null
				} ?: continue
				resource.inputStream
					.bufferedReader()
					.readText()
					.let { grammar.parseToEnd(it) }
					.toExpressionTree()
					.let { set(entity, it) }
			}
		}
	}, executor)!!
}
