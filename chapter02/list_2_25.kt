import java.io.BufferedReader
import java.io.*

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'
fun recognize(c: Char) = when(c) {
	in '0'..'9' -> "It's a digit!"
	in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
	else -> "I don't know..."
}

fun readNumber(reader: BufferedReader): Int? {
	try {
		val line = reader.readLine()
		return Integer.parseInt(line)
	}
	catch(e: NumberFormatException) {
		return null
	}
	finally {
		reader.close()
	}
}

fun readNumber2(reader: BufferedReader) {
	val number = try {
		Integer.parseInt(reader.readLine())
	} catch (e: NumberFormatException) {
		return
	}

	println(number)
}

fun readNumberException(reader: BufferedReader) {
	val number = try {
		Integer.parseInt(reader.readLine())
	} catch (e: NumberFormatException) {
		null
	}

	println(number)
}

fun main(args: Array<String>) {
	println(isLetter('q'))
	println(isNotDigit('x'))
	println(recognize('8'))
	println("Kotlin" in "Java".."Scala")
	println("Kotlin" in setOf("Java", "Scala"))

	val reader = BufferedReader(StringReader("239"))
	readNumber2(reader)

	val exceptionReader = BufferedReader(StringReader("not a number"))
	readNumberException(exceptionReader)
}