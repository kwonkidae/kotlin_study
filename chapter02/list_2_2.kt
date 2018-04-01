class Person(
	val name: String,
	var isMarried: Boolean
)

class Rectangle(val height: Int, val width: Int) {
	val isSquare: Boolean
		get() {
			return height == width
		}
}

enum class Color (
	val r: Int, val g: Int, val b: Int
) {
	RED(255, 0, 0), ORANGE(255, 165, 0),
	YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
	INDIGO(75, 0, 130), VIOLET(238, 130, 238);

	fun rgb() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color: Color) =
	when (color) {
		Color.RED -> "Richard"
		Color.ORANGE -> "Of"
		Color.YELLOW -> "York"
		Color.GREEN -> "Gave"
		Color.BLUE -> "Battle"
		Color.INDIGO -> "In"
		Color.VIOLET -> "Vain"
	}

fun getWarmth(color: Color) = when (color) {
	Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
	Color.GREEN -> "neutral"
	Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

fun main(args: Array<String>) {
	val name = if (args.size > 0) args[0] else "Kotlin"
	println("Hello, $name!")

	val person = Person("Bob", true)
	println(person.name)
	println(person.isMarried)

	val rectangle = Rectangle(41, 43)
	println(rectangle.isSquare)
	println(Color.BLUE.rgb())
	println(getMnemonic(Color.BLUE))
	println(getWarmth(Color.ORANGE))
}