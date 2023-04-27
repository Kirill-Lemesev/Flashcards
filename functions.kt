package flashcards

import java.io.File


var termDefinition = mutableMapOf<String, String> ()
var cardStatistic = mutableMapOf<String, Int> ()
var log = mutableListOf<String>()

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
        cardStatistic.remove(cardName)
        termDefinition.remove(cardName)
        printlnAndLog("The card has been removed.")
    } else {
        printlnAndLog("Can't remove \"$cardName\": there is no such card")
    }

}


fun import(filePath: String? = null) {
    val file: File
    if (filePath == null) {
        printlnAndLog("File name:")
        file = File(readAndLog())
    } else {
        file = File(filePath)
    }
    if (file.exists()) {
        var counter = 0
        file.forEachLine {
            val keyValue = it.split(":")
            termDefinition[keyValue[0]] = keyValue[1]
            val attempt = keyValue[2].toInt()
            if (attempt > 0 ) cardStatistic[keyValue[0]] = attempt
            counter += 1
        }
        printlnAndLog("$counter cards have been loaded")
    } else {
        printlnAndLog("File not found")
    }
}


fun export(filePath: String? = null) {
    val file: File
    var counter = 0
    if (filePath == null) {
        printlnAndLog("File name:")
        file = File(readAndLog())
    } else {
        file = File(filePath)
    }
    file.writeText("")
    for ((key, value) in termDefinition) {
        if (key in cardStatistic.keys) {
            file.appendText("$key:$value:${cardStatistic[key]}\n")
        } else {
            file.appendText("$key:$value:0\n")
        }
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
                cardStatistic[randomKey] = (cardStatistic[randomKey] ?: 0) + 1
                for (key in termDefinition.keys) {
                    if (answer == termDefinition[key]) {
                        printlnAndLog("Wrong. The right answer is \"${termDefinition[randomKey]}\", but your definition is correct for \"$key\"")
                    }
                }
            }
            else -> {
                cardStatistic[randomKey] = (cardStatistic[randomKey] ?: 0) + 1
                printlnAndLog("Wrong. The right answer is \"${termDefinition[randomKey]}\"")
            }
        }
    }
}


fun log() {
    printlnAndLog("File name:")
    val file = File(readAndLog())
    file.writeText(log.joinToString("\n"))
    printlnAndLog("The log has been saved.")
}

fun hardestCard() {
    var errors = 0
    for (statistic in cardStatistic.values) {
        if (statistic > errors) errors = statistic
    }
    val keys = mutableListOf<String>()
    for ((key, value) in cardStatistic.entries) {
        if (value == errors) keys.add("\"$key\"")
    }

    when (keys.size) {
        0 -> {
            printlnAndLog("There are no cards with errors")
        }
        1 -> {
            printlnAndLog("The hardest card is ${keys[0]}. You have $errors errors answering it.")
        }
        else -> {
            printlnAndLog("The hardest cards are ${keys.joinToString(", ")}. You have $errors errors answering them.")
        }
    }

}

fun resetStats() {
    cardStatistic.clear()
    printlnAndLog("Card statistics have been reset")
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