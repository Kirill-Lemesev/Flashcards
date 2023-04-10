package flashcards

import java.io.File


fun add() {

    println("The card:")
    val term = readln()
    if (termDefinition.containsKey(term)) {
        println("The card \"$term\" already exists.")
    } else {
        println("The definition of the card:")
        val definition = readln()
        if (termDefinition.containsValue(definition)) {
            println("The definition \"$definition\" already exists.")
        } else {
            termDefinition[term] = definition
            println("The pair (\"$term\":\"$definition\") has been added.")
        }

    }

}


fun remove() {

    println("Which card?")
    val cardName = readln()
    if (termDefinition.containsKey(cardName)) {
        termDefinition.remove(cardName)
        println("The card has been removed.")
    } else {
        println("Can't remove \"$cardName\": there is no such card")
    }

}


fun import() {

    println("File name:")
    val file = File(readln())
    if (file.exists()) {
        var counter = 0
        file.forEachLine {
            val keyValue = it.split(":")
            termDefinition[keyValue[0]] = keyValue[1]
            counter += 1
        }
        println("$counter cards have been loaded")

    } else {
            println("File not found")
        }
}


fun export() {

    println("File name:")
    val file = File(readln())
    var counter = 0
    file.writeText("")
    for ((key, value) in termDefinition) {
        file.appendText("$key:$value\n")
        counter += 1
    }
    //file.writeText(termDefinition.toString())
    println("$counter cards have been saved")
}


fun ask() {

    println("How many times to ask?")
    val numberOfCards = readln().toInt()
    repeat(numberOfCards) {
        val randomKey = termDefinition.keys.random()
        println("Print the definition of \"$randomKey\":")
        when (val answer = readln()) {
            termDefinition[randomKey] -> {
                println("Correct!")
            }
            in termDefinition.values -> {
                for (key in termDefinition.keys) {
                    if (answer == termDefinition[key]) {
                        println("Wrong. The right answer is \"${termDefinition[randomKey]}\", but your definition is correct for \"$key\"")
                    }
                }
            }
            else -> {
                println("Wrong. The right answer is \"${termDefinition[randomKey]}\"")
            }
        }
    }
}



