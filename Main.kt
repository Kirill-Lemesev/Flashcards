package flashcards

fun main() {

    val term = readln().toString()
    val definition = readln().toString()
    val answer = readln().toString()
    if (definition == answer) println("Your answer is right!") else println("Your answer is wrong!")
}
