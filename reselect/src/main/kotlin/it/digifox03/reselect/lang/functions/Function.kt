package it.digifox03.reselect.lang.functions

fun interface Function {
	fun make(expr: List<Expression>): Expression
}
