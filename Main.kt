package flashcards


var termDefinition = mutableMapOf<String, String> ()


fun main() {

    while (true) {
        println("Input the action (add, remove, import, export, ask, exit):")
        when (readln()) {
            "add" -> add()
            "remove" -> remove()
            "import" -> import()
            "export" -> export()
            //"ask" -> // TODO
            "exit" -> {
                println("Bye bye!")
                break
            }
        }
    }


}
