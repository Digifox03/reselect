package it.digifox03.reselect.lang

import it.digifox03.reselect.lang.ast.*
import it.digifox03.reselect.lang.ast.ExpressionTree as Et

fun AbstractSyntaxTree.toExpressionTree(): Et {
	return Et(astExpr2etExpr(this, mapOf()))
}

private data class Decl(
	val params: List<String>,
	val expr: Et.Expr
)
private typealias DeclMap = Map<String, Decl>
private typealias RenameMap = Map<String, Et.Expr>

private fun astExpr2etExpr(expr: AbstractSyntaxTree, decl: DeclMap): Et.Expr {
	when (expr) {
		is FunctionCall -> {
			val params = expr.arguments.map { param ->
				astExpr2etExpr(param, decl)
			}
			val d = decl[expr.name] ?: return Et.Function(expr.name, params)
			val args = d.params.mapIndexed { i, name ->
				name to params[i]
			}.toMap()
			return rename(d.expr, args)
		}
		is Definition -> {
			val def = Decl(
				expr.parameters.toList(),
				astExpr2etExpr(expr.definition, decl)
			)
			return astExpr2etExpr(expr.expression, decl + (expr.name to def))
		}
		is IntegerConstant -> return Et.Primitive(PrimitiveInteger(expr.value))
		is DecimalConstant -> return Et.Primitive(PrimitiveNumber(expr.value))
		is BooleanConstant -> return Et.Primitive(PrimitiveBoolean(expr.value))
		is StringConstant -> return Et.Primitive(PrimitiveString(expr.value))
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
