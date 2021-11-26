package it.digifox03.reselect.lang.core

fun <T> poly1(
	reg: TypeClassRegister<T, *>,
	ret: String? = null,
	func: (T, Any) -> Any
) = Function { (a) ->
	@Suppress("UNCHECKED_CAST")
	val tc = requireNotNull(reg.getInstance(a.type))
	object : Expression {
		override val type = ret ?: a.type
		override fun value(): Any = func(tc, a.value())
	}
}

fun <T> poly2(
	reg: TypeClassRegister<T, *>,
	ret: String? = null,
	func: (T, Any, Any) -> Any
) = Function { (a, b) ->
	require(a.type == b.type)
	@Suppress("UNCHECKED_CAST")
	val tc = requireNotNull(reg.getInstance(a.type))
	object : Expression {
		override val type = ret ?: a.type
		override fun value(): Any = func(tc, a.value(), b.value())
	}
}
