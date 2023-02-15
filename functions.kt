package flashcards
import java.io.File

fun add(fileName: String){
    val termDefinition = mutableMapOf<String, String>()
    File(fileName).forEachLine {
        val (key, value) = it.split(' ')
        termDefinition[key] = value
    }
    println("The card")
    var term = readln()
    while (term in termDefinition.keys) {
        println("The card \"$term\" already exists. Try again:")
        term = readln()
    }
    println("The definition of the card:")
    var definition = readln()
    while (term in termDefinition.values) {
        println("The card \"$term\" already exists. Try again:")
        definition = readln()
    }
    File(fileName).writeText("$term $definition")
    println("The pair (\"$term\":\"$definition\") has been added.")
}


fun remove(){

}

fun import(){

}

fun export(){

}

fun ask(){

}