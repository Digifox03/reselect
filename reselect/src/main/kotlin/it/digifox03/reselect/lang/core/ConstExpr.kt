package it.digifox03.reselect.lang.core

class ConstExpr(
	override val type: String,
	private val value: Any
): Expression {
	override fun value() = value
}
