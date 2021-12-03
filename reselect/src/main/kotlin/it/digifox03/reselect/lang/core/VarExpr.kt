package it.digifox03.reselect.lang.core

class VarFunction(type: String): Function {
	var value: Any? = null
	private val varExpression = object: Expression {
		override val type = type
		override fun value(): Any = value!!
	}

	override fun make(expr: List<Expression>) = varExpression
}
