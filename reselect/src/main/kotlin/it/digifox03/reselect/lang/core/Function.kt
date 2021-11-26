package it.digifox03.reselect.lang.core

fun interface Function {
	fun make(expr: List<Expression>): Expression
}
