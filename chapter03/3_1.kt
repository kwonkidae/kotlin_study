import java.util.*
import java.io.*

fun <T> joinToString(
	collection: Collection<T>,
	separator: String,
	prefix: String,
	postfix: String
): String {
	val result = StringBuilder(prefix)

	for ((index, element) in collection.withIndex()) {
		if (index > 0) result.append(separator)
		result.append(element)
	}
	result.append(postfix)
	return result.toString()
}

fun main(args: Array<String>) {
	val set = hashSetOf(1, 7, 53)
	println(set.javaClass)

	val list = arrayListOf(1, 7 ,53)
	val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
	println(list.javaClass)
	println(map.javaClass)

	val strings = listOf("first", "second", "fourteenth")
	println(strings.last())

	val numbers = setOf(1, 14, 2)
	println(numbers.max())

	println(joinToString(set, separator = ";", prefix = "(", postfix = ")"))
}