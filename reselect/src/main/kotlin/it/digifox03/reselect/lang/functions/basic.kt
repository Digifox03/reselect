package it.digifox03.reselect.lang.functions

class ConstExpr(
	override val type: String,
	private val value: Any
): Expression {
	override fun value() = value
}

class IfExpression(
	private val cond: Expression,
	private val r1: Expression,
	private val r2: Expression
): Expression {
	init {
		require(cond.type == "boolean")
		require(r1.type == r2.type)
	}
	override val type = r1.type
	override fun value(): Any {
		return if (cond.value() as Boolean) {
			r1.value()
		} else {
			r2.value()
		}
	}
}

private fun func3(f: (Expression, Expression, Expression) -> Expression) =
	Function { (v1, v2, v3) -> f(v1, v2, v3)}

private inline fun <reified L, reified R> binOp(
	type: String, lhs: Expression, rhs: Expression,
	crossinline op: (L, R) -> Any
): Expression = object : Expression {
	override val type = type
	override fun value(): Any {
		return op(lhs.value() as L, rhs.value() as R)
	}
}

private inline fun <reified V> unOp(
	type: String, value: Expression,
	crossinline op: (V) -> Any
): Expression = object : Expression {
	override val type = type
	override fun value(): Any {
		return op(value.value() as V)
	}
}

private fun mathBinOp(
	int: (Long, Long) -> Any,
	num: (Double, Double) -> Any,
	type: String? = null
) = Function { (lhs, rhs) ->
	require(lhs.type == rhs.type)
	when (lhs.type) {
		"integer" -> binOp(type ?: "integer", lhs, rhs, int)
		"number" -> binOp(type ?: "number", lhs, rhs, num)
		else -> error("bad type")
	}
}

private fun mathUnOp(
	int: (Long) -> Any,
	num: (Double) -> Any,
	type: String? = null
) = Function { (value) ->
	when (value.type) {
		"integer" -> unOp(type ?: "integer", value, int)
		"number" -> unOp(type ?: "number", value, num)
		else -> error("bad type")
	}
}

private fun baseOp(
	int: (Long, Long) -> Long,
	num: (Double, Double) -> Double
) = Function { (lhs, rhs) ->
	require(lhs.type == rhs.type)
	when (lhs.type) {
		"integer" -> binOp("integer", lhs, rhs, int)
		"number" -> binOp("number", lhs, rhs, num)
		else -> error("bad type")
	}
}

val functions = mapOf(
	"if" to func3(::IfExpression),
	"u+" to mathUnOp({ a -> +a }, { a -> +a}),
	"u-" to mathUnOp({ a -> -a }, { a -> -a}),
	"+"  to mathBinOp({ a, b -> a + b },  { a, b -> a + b }),
	"-"  to mathBinOp({ a, b -> a - b },  { a, b -> a - b }),
	"*"  to mathBinOp({ a, b -> a * b },  { a, b -> a * b }),
	"/"  to mathBinOp({ a, b -> a / b },  { a, b -> a / b }),
	"==" to mathBinOp({ a, b -> a == b }, { a, b -> a == b }, "boolean"),
	"!=" to mathBinOp({ a, b -> a != b }, { a, b -> a != b }, "boolean"),
	">"  to mathBinOp({ a, b -> a > b },  { a, b -> a > b },  "boolean"),
	"<"  to mathBinOp({ a, b -> a < b },  { a, b -> a < b },  "boolean"),
	">=" to mathBinOp({ a, b -> a >= b }, { a, b -> a >= b }, "boolean"),
	"<=" to mathBinOp({ a, b -> a <= b }, { a, b -> a <= b }, "boolean"),
)
