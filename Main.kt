package flashcards

fun main() {

    println("Input the number of cards:")
    val numberOfCards = readln().toInt()
    val termsList = mutableListOf<String>()
    val definitionList = mutableListOf<String>()
    for (i in 1..numberOfCards) {
        println("Card #$i:")
        var term = readln()
        while (term in termsList) {
            println("The term \"$term\" already exists. Try again:")
            term = readln()
        }
        termsList.add(term)
        println("The definition for card #$i:")
        var definition = readln()
        while (definition in definitionList) {
            println("The term \"$definition\" already exists. Try again:")
            definition = readln()
        }
        definitionList.add(definition)
    }

    for (i in 0..numberOfCards - 1) {
        println("The definition for \"${termsList[i]}\"")
        val answer = readln()
        when (answer) {
            definitionList[i] -> {
                println("Correct!")
            }
            in definitionList -> {
                val termIndex  = definitionList.indexOf(answer)
                println("Wrong. The right answer is \"${definitionList[i]}\", but your definition is correct for \"${termsList[termIndex]}\".")
            }
            else -> {
                println("Wrong. The right answer is \"${definitionList[i]}\"")
            }
        }
    }

}