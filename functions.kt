package flashcards

import java.io.File


fun add() {

    printlnAndLog("The card:")
    val term = readAndLog()
    if (termDefinition.containsKey(term)) {
        printlnAndLog("The card \"$term\" already exists.")
    } else {
        printlnAndLog("The definition of the card:")
        val definition = readAndLog()
        if (termDefinition.containsValue(definition)) {
            printlnAndLog("The definition \"$definition\" already exists.")
        } else {
            termDefinition[term] = definition
            printlnAndLog("The pair (\"$term\":\"$definition\") has been added.")
        }

    }

}


fun remove() {

    printlnAndLog("Which card?")
    val cardName = readAndLog()
    if (termDefinition.containsKey(cardName)) {
        termDefinition.remove(cardName)
        printlnAndLog("The card has been removed.")
    } else {
        printlnAndLog("Can't remove \"$cardName\": there is no such card")
    }

}


fun import() {

    printlnAndLog("File name:")
    val file = File(readAndLog())
    if (file.exists()) {
        var counter = 0
        file.forEachLine {
            val keyValue = it.split(":")
            termDefinition[keyValue[0]] = keyValue[1]
            counter += 1
        }
        printlnAndLog("$counter cards have been loaded")

    } else {
        printlnAndLog("File not found")
        }
}


fun export() {

    printlnAndLog("File name:")
    val file = File(readAndLog())
    var counter = 0
    file.writeText("")
    for ((key, value) in termDefinition) {
        file.appendText("$key:$value\n")
        counter += 1
    }
    printlnAndLog("$counter cards have been saved")
}


fun ask() {

    printlnAndLog("How many times to ask?")
    val numberOfCards = readAndLog().toInt()
    repeat(numberOfCards) {
        val randomKey = termDefinition.keys.random()
        printlnAndLog("Print the definition of \"$randomKey\":")
        when (val answer = readAndLog()) {
            termDefinition[randomKey] -> {
                printlnAndLog("Correct!")
            }
            in termDefinition.values -> {
                for (key in termDefinition.keys) {
                    if (answer == termDefinition[key]) {
                        printlnAndLog("Wrong. The right answer is \"${termDefinition[randomKey]}\", but your definition is correct for \"$key\"")
                    }
                }
            }
            else -> {
                printlnAndLog("Wrong. The right answer is \"${termDefinition[randomKey]}\"")
            }
        }
    }
}

fun log() {
    printlnAndLog("File name:")
    val file = File(readAndLog())
    for (line in log) file.appendText("$line\n")
    println("The log has been saved.")
}

fun readAndLog(): String {
    val input = readln()
    log.add(input)
    return input
}

fun printlnAndLog(text: String) {
    log.add(text)
    println(text)
}