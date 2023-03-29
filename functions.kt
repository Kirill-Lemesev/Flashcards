package flashcards
import java.io.File

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


/*

fun import(){

}

fun export(){

}

fun ask(){

}
*/