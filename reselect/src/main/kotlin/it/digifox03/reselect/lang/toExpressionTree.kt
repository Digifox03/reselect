package it.digifox03.reselect.lang

import it.digifox03.reselect.lang.ast.AbstractExpressionTree as Ast
import it.digifox03.reselect.lang.ast.ExpressionTree as Et

fun Ast.toExpressionTree(): Et {
	return Et(astExpr2etExpr(expr, mapOf()))
}

private data class Decl(
	val params: List<String>,
	val expr: Et.Expr
)
private typealias DeclMap = Map<String, Decl>
private typealias RenameMap = Map<String, Et.Expr>

private fun astExpr2etExpr(expr: Ast.Expr, decl: DeclMap): Et.Expr {
	when (expr) {
	is Ast.Function -> {
		val params = expr.params.map { param ->
			astExpr2etExpr(param, decl)
		}
		val d = decl[expr.name] ?: return Et.Function(expr.name, params)
		val args = d.params.mapIndexed { i, name ->
			name to params[i]
		}.toMap()
		return rename(d.expr, args)
	}
	is Ast.Primitive ->
		return Et.Primitive(expr.primitive)
	is Ast.Let -> {
		val def = Decl(expr.params, astExpr2etExpr(expr.def, decl))
		return astExpr2etExpr(expr.block, decl + (expr.name to def))
	}
	}
}

private fun rename(expr: Et.Expr, map: RenameMap): Et.Expr {
	return when (expr) {
	is Et.Function -> {
		val newExpr = map[expr.name]
		if (newExpr != null) {
			newExpr
		} else {
			val params = expr.params.map { param ->
				rename(param, map)
			}
			Et.Function(expr.name, params)
		}
	}
	is Et.Primitive -> expr
	}
}
