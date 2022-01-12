package it.digifox03.reselect.lang.core

open class TypeClassRegister<out T, in R>(
	private vararg val subclasses: TypeClassRegister<*, R>,
	val name: String
) {
	private val instances = mutableMapOf<String, T>()
	fun getInstance(name: String): T? = instances[name]
	@Suppress("UNCHECKED_CAST")
	fun register(name: String, value: R) {
		instances[name] = value as T
		subclasses.forEach { it.register(name, value) }
	}
}
