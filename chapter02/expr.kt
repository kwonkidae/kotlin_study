interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
	if (e is Num) {
		e.value
	} else if (e is Sum) {
		eval(e.right) + eval(e.left)
	} else {
		throw IllegalArgumentException("Unknown expression")
	}

fun eval_when(e: Expr) : Int =
	when (e) {
		is Num ->
			e.value
		is Sum ->
			eval(e.right) + eval(e.left)
		else ->
			throw IllegalArgumentException("Unknown expression")
	}


fun main(args: Array<String>) {
	println("Expr")
	println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
	println(eval_when(Sum(Num(1), Num(2))))
}