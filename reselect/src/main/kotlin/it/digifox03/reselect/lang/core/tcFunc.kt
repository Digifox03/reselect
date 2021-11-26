package it.digifox03.reselect.lang.core

fun <T> poly1(
	reg: TypeClassRegister<T, *>,
	ret: String? = null,
	func: (T, Any) -> Any
) = Function { (a) ->
	val type = ret ?: a.type
	val tc = requireNotNull(reg.getInstance(a.type))
	if (a is ConstExpr)
		return@Function ConstExpr(type, func(tc, a.value()))
	object : Expression {
		override val type = type
		override fun value(): Any = func(tc, a.value())
	}
}

fun <T> poly2(
	reg: TypeClassRegister<T, *>,
	ret: String? = null,
	func: (T, Any, Any) -> Any
) = Function { (a, b) ->
	val type = ret ?: a.type
	require(a.type == b.type)
	val tc = requireNotNull(reg.getInstance(a.type))
	if (a is ConstExpr && b is ConstExpr)
		return@Function ConstExpr(type, func(tc, a.value(), b.value()))
	object : Expression {
		override val type = ret ?: a.type
		override fun value(): Any = func(tc, a.value(), b.value())
	}
}
