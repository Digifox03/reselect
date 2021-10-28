package it.digifox03.reselect.lang.ast

data class AbstractExpressionTree(val expr: Expr) {
	sealed class Expr
	data class Primitive(
		val primitive: BasePrimitive,
	): Expr()
	data class Function(
		val name: Name,
		val params: List<Expr>,
	): Expr()
	data class Let(
		val name: Name,
		val params: List<Name>,
		val def: Expr,
		val block: Expr,
	): Expr()
}


