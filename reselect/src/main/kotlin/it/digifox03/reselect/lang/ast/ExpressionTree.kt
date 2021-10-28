package it.digifox03.reselect.lang.ast

data class ExpressionTree(val expr: Expr) {
	sealed class Expr
	data class Primitive(
		val primitive: BasePrimitive,
	): Expr()
	data class Function(
		val name: Name,
		val params: List<Expr>,
	): Expr()
}
