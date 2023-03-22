package flashcards
import java.io.File

fun add(){

    println("The card")
    var term = readln()
    while (term in termDefinition.keys) {
        println("The card \"$term\" already exists. Try again:")
        term = readln()
    }
    println("The definition of the card:")
    var definition = readln()
    while (definition in termDefinition.values) {
        println("The card \"$term\" already exists. Try again:")
        definition = readln()
    }


    println("The pair (\"$term\":\"$definition\") has been added.")
}

/*
fun remove(){

}


fun import(){

}

fun export(){

}

fun ask(){

}
*/