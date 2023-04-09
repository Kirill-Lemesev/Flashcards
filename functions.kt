package flashcards

import java.io.File
import kotlin.random.Random

fun add() {

    println("The card")
    var term = readln()
    while (termDefinition.containsKey(term)) {
        println("The card \"$term\" already exists. Try again:")
        term = readln()
    }
    println("The definition of the card:")
    var definition = readln()
    while (termDefinition.containsValue(definition)) {
        println("The card \"$term\" already exists. Try again:")
        definition = readln()
    }

    termDefinition[term] = definition
    println("The pair (\"$term\":\"$definition\") has been added.")
}


fun remove() {

    println("Which card?")
    val cardName = readln()
    if (termDefinition.containsKey(cardName)) {
        termDefinition.remove(cardName)
        println("The card has been removed.")
        println(termDefinition)
    } else {
        println("Can't remove \"$cardName\": there is no such card")
    }

}


fun import() {
    println("File name:")
    val file = File(readln())
    var counter = 0

    if (file.exists()) {
        file.forEachLine {
            counter += 1
            val keyValue = it.split(" ")
            if (keyValue[0] in termDefinition.values) {
                termDefinition[keyValue[0]] = keyValue[1]
            } else {
                termDefinition[keyValue[0]] = keyValue[1]
            }
        }
        println("$counter cards have been loaded")
    } else {
        println("File not found")
    }
}


fun export() {
    println("File name:")
    val file = File(readln())
    file.writeText(termDefinition.toString())
    println("${termDefinition.size} cards have been saved")
}


fun ask() {
    println("How many times to ask?")
    val numberOfCards = readln().toInt()
    repeat(numberOfCards) {
        val randomKey = termDefinition.keys.random()
        println("The definition for \"${termDefinition[randomKey]}\"")
        val answer = readln()
        when (answer) {
            termDefinition[randomKey] -> {
                println("Correct!")
            }

            in termDefinition.values -> {
                for (key in termDefinition.keys) {
                    if (answer == termDefinition[key]) {
                        println("Wrong. The right answer is \"${termDefinition[randomKey]}\", but your definition is correct for \"${termDefinition[key]}\".")
                    }

                }
            }

            else -> {
                println("Wrong. The right answer is \"${termDefinition[randomKey]}\"")
            }
        }
    }
}



