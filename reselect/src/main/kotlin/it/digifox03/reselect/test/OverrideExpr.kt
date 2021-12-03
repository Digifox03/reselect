package it.digifox03.reselect.test

import it.digifox03.reselect.lang.ast.ExpressionTree
import it.digifox03.reselect.lang.core.Expression
import it.digifox03.reselect.lang.core.VarFunction
import it.digifox03.reselect.lang.coreFunctions
import it.digifox03.reselect.lang.toEvalTree
import it.digifox03.reselect.minecraft.minecraftFunctions
import net.minecraft.entity.Entity
import net.minecraft.util.Identifier

class OverrideExpr(name: String, tree: ExpressionTree) {
	private val variable = VarFunction(name)
	private val defaultVar = VarFunction("string")
	private val expr: Expression = tree.toEvalTree(
		coreFunctions
			+ minecraftFunctions
			+ (name to variable)
			+ ("default" to defaultVar)
	).also {
		require(it.type == "string")
	}
	fun call(entity: Entity, default: Identifier): Identifier {
		variable.value = entity
		defaultVar.value = default.toString()
		return Identifier.tryParse(expr.value() as String)!!
	}
}
