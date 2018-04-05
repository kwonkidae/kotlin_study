import java.util.*
import java.io.*

fun main(args: Array<String>) {
	val list = listOf(1,2,3)
	println(list.joinToString())
	val view: View = Button()
	view.click()

	println(view.showOff())
	println("Kotlin".lastChar)
	val sb = StringBuilder("Kotlin?")
	sb.lastChar = '!'
	println(sb)
}

val String.lastChar: Char
	get() = get(length-1)

var StringBuilder.lastChar: Char
	get() = get(length-1)
	set(value: Char) {
		this.setCharAt(length - 1, value)
	}

open class View {
	open fun click() = println("View clicked")
}

class Button: View() {
	override fun click() = println("Button clicked")
}

fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")

fun <T> Collection<T>.joinToString(
	separator: String = ", ",
	prefix: String = "",
	postfix: String = ""
): String {
	val result = StringBuilder(prefix)

	for ((index, element) in this.withIndex()) {
		if (index > 0) result.append(separator)
		result.append(element)
	}

	result.append(postfix)
	return result.toString()
}

