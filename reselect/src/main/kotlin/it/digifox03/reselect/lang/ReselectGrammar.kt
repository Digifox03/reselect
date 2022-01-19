package it.digifox03.reselect.lang

import com.github.h0tk3y.betterParse.combinators.*
import com.github.h0tk3y.betterParse.grammar.Grammar
import com.github.h0tk3y.betterParse.grammar.parser
import com.github.h0tk3y.betterParse.lexer.literalToken
import com.github.h0tk3y.betterParse.lexer.regexToken
import com.github.h0tk3y.betterParse.parser.Parser
import it.digifox03.reselect.lang.ast.AbstractExpressionTree.*
import it.digifox03.reselect.lang.ast.*

/*
 * This mess has to be replaced by an actual parser + lexer
 */
class ReselectGrammar: Grammar<AbstractExpressionTree>() {
	@Suppress("unused")
	val whitespace by regexToken("\\s+", ignore = true)
	@Suppress("unused")
	val comment by regexToken("--[^\\n]*\\n", ignore = true)

	private val `if` by regexToken("if\\b")
	private val then by regexToken("then\\b")
	private val `else` by regexToken("else\\b")
	private val elseif by regexToken("elseif\\b")
	private val end by regexToken("end\\b")
	private val `true` by regexToken("true\\b")
	private val `false` by regexToken("false\\b")
	private val let by regexToken("let\\b")
	private val `in` by regexToken("in\\b")
	private val not by regexToken("not\\b")
	private val and by regexToken("and\\b")
	private val or by regexToken("or\\b")

	private val identifier by
		regexToken("[a-zA-Z_][a-zA-Z0-9_']*")
	private val number by
		regexToken("[0-9]*[.][0-9]+(?:[eE][+-]?[0-9]+)?")
	private val hexInteger by
		regexToken("0x[0-9a-fA-F]+")
	private val integer by
		regexToken("[0-9]+")
	private val string by
		regexToken("\"(?:\\\\\"|[^\"])*\"")

	private val lpar by literalToken("(")
	private val rpar by literalToken(")")
	private val comma by literalToken(",")
	private val dot by literalToken(".")
	private val add by literalToken("+")
	private val sub by literalToken("-")
	private val mul by literalToken("*")
	private val div by literalToken("/")
	private val ge by literalToken(">=")
	private val le by literalToken("<=")
	private val gt by literalToken(">")
	private val lt by literalToken("<")
	private val eq by literalToken("==")
	private val ne by literalToken("!=")
	private val def by literalToken(":=")

	private fun String.parseString(): String {
		return substring(1 until length - 1)
			.replace("\\\"", "\"")
			.replace("\\\n","\n")
			.replace("\\\t","\t")
	}

	private val notP = not map { OperatorName.notName }
	private val upP = add map { OperatorName.upName }
	private val umP = sub map { OperatorName.umName }

	private val mulP = mul map { OperatorName.mulName }
	private val divP = div map { OperatorName.divName }
	private val addP = add map { OperatorName.addName }
	private val subP = sub map { OperatorName.subName }

	private val ltP = lt map { OperatorName.ltName }
	private val gtP = gt map { OperatorName.gtName }
	private val leP = le map { OperatorName.leName }
	private val geP = ge map { OperatorName.geName }
	private val eqP = eq map { OperatorName.eqName }
	private val neP = ne map { OperatorName.neName }

	private val andP = and map { OperatorName.andName }
	private val orP = or map { OperatorName.orName }

	private val numberP =
		number map { token ->
			prim(token.text.toDouble())
		}
	private val decIntegerP =
		integer map { token ->
			prim(token.text.toLong())
		}
	private val hexIntegerP =
		hexInteger map { token ->
			prim(token.text.drop(2).toLong(16))
		}
	private val integerP =
		decIntegerP or hexIntegerP
	private val stringP =
		string map {
			prim(it.text.parseString())
		}
	private val trueP =
		`true` map {
			prim(true)
		}
	private val falseP =
		`false` map {
			prim(false)
		}
	private val name =
		identifier map { token ->
			token.text
		}

	private val exprP = parser(this::expr)

	private val callBlock =
		separated(exprP, comma) map { ops ->
			ops.terms
		}
	private val call =
		skip(lpar) and callBlock and skip(rpar)

	private val primitive =
		numberP or integerP or stringP or trueP or falseP map {
			Primitive(it)
		}

	private val ifOpts =
		separated(exprP and skip(then) and exprP, elseif)
	private val ifBlock =
		ifOpts and skip(`else`) and exprP map { (opts, def) ->
			opts.terms.foldRight(def) { (c, r), e ->
				Function(OperatorName.ifName, listOf(c, r, e))
			}
		}
	private val ifExpr =
		skip(`if`) and ifBlock and skip(end)

	private val dotForm =
		name and skip(dot) and name map {
			it.t2 to it.t1
		}
	private val functionForm =
		name map {
			it to null
		}
	private val declName =
		dotForm or functionForm
	private val arguments =
		skip(lpar) and separated(name, comma) and skip(rpar) map { a ->
			a.terms
		}
	private val signature =
		declName and optional(arguments) map { (n, a) ->
			val name = n.first
			val arg0 = (n.second?.let { listOf(it) } ?: emptyList())
			val args = (a ?: emptyList())
			name to arg0 + args
		}
	private val decl =
		signature and skip(def) and exprP map { (sign, expr) ->
			Triple(sign.first, sign.second, expr)
		}
	private val letBlock =
		oneOrMore(decl) and skip(`in`) and exprP map { (decl, expr0) ->
			decl.foldRight(expr0) { (name, params, value), expr ->
				Let(name, params, value, expr)
			}
		}
	private val letExpr =
		skip(let) and letBlock and skip(end)

	private val funExpr =
		name and optional(call) map { (name, params) ->
			Function(name, params ?: emptyList())
		}

	private val parExpr =
		skip(lpar) and exprP and skip(rpar)

	private val priExpr =
		letExpr or parExpr or ifExpr or primitive or funExpr

	private val access =
		skip(dot) and name and optional(call) map {(name, args) ->
			name to (args ?: emptyList())
		}
	private val accExpr =
		priExpr and zeroOrMore(access) map {(expr, acc) ->
			acc.fold(expr) { e, (name, call) ->
				Function(name, listOf(e) + call)
			}
		}

	private val unOp =
		notP or umP or upP
	private val unExpr =
		zeroOrMore(unOp) and accExpr map { (op, e) ->
			op.foldRight(e) { name, expr ->
				Function(name, listOf(expr))
			}
		}

	private fun operator(expr: Parser<Expr>, op: Parser<String>) =
		expr and zeroOrMore(op and expr) map { (e, ops) ->
			ops.fold(e) { lhs, (name, rhs) ->
				Function(name, listOf(lhs, rhs))
			}
		}

	private val mulExpr =
		operator(unExpr, mulP or divP)

	private val addExpr =
		operator(mulExpr, addP or subP)

	private val relExpr =
		operator(addExpr, ltP or gtP or leP or geP or eqP or neP)

	private val andExpr =
		operator(relExpr, andP)

	private val orExpr =
		operator(andExpr, orP)

	private val expr: Parser<Expr> = orExpr

	override val rootParser = expr map { AbstractExpressionTree(it) }
}
