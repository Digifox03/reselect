package it.digifox03.reselect.lang.ast

sealed class BasePrimitive

data class PrimitiveString(val string: String): BasePrimitive()
data class PrimitiveNumber(val number: Double): BasePrimitive()
data class PrimitiveInteger(val integer: Long): BasePrimitive()
data class PrimitiveBoolean(val boolean: Boolean): BasePrimitive()

fun prim(string: String) = PrimitiveString(string)
fun prim(number: Double) = PrimitiveNumber(number)
fun prim(integer: Long) = PrimitiveInteger(integer)
fun prim(boolean: Boolean) = PrimitiveBoolean(boolean)
