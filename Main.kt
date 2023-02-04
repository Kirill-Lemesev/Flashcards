package flashcards

fun main() {

    println("Input the number of cards:")
    val numberOfCards = readln().toInt()
    val termsList = mutableListOf<String>()
    val definitionList = mutableListOf<String>()
    for (i in 1..numberOfCards) {
        println("Card #$i:")
        val term = readln()
        termsList.add(term)
        println("The definition for card #$i:")
        val definition = readln()
        definitionList.add(definition)
    }

    for (i in 0..numberOfCards - 1) {
        println("The definition for \"${termsList[i]}\"")
        val answer = readln()
        if (answer == definitionList[i]) println("Correct!") else println("Wrong. The right answer is \"${definitionList[i]}\"")

    }

}
