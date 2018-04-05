import java.util.TreeMap

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

fun evalWithLogging(e: Expr) : Int =
	when (e) {
		is Num -> {
			println("num: ${e.value}")
			e.value
		}
		is Sum -> {
			val left = evalWithLogging(e.left)
			val right = evalWithLogging(e.right)
			println("sum: $left + $right")
			left + right
		}
		else -> throw IllegalArgumentException("Unknown expression")
	}

fun fizzBuzz(i: Int) = when {
	i % 15 == 0 -> "FizzBuzz "
	i % 3 == 0 -> "Fizz "
	i % 5 == 0 -> "Buzz "
	else -> "$i "
}

val binaryReps = TreeMap<Char, String>()

fun main(args: Array<String>) {
	println("Expr")
	println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
	println(evalWithLogging(Sum(Num(1), Num(2))))

	// for (i in 100 downTo 1 step 2) {
	// 	print(fizzBuzz(i))
	// }

	for (c in 'A'..'F') {
		val binary = Integer.toBinaryString(c.toInt())
		binaryReps[c] = binary
	}

	for ((letter, binary) in binaryReps) {
		println("$letter = $binary")
	}

}