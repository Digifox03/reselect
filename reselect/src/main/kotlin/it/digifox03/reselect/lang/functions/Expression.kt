package it.digifox03.reselect.lang.functions

interface Expression {
	val type: String
	fun value(): Any
}
