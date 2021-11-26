package it.digifox03.reselect.lang.core

interface Expression {
	val type: String
	fun value(): Any
}
