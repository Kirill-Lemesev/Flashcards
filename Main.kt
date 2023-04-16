package flashcards


var termDefinition = mutableMapOf<String, String> ()
var log = mutableListOf<String>()
// TODO make your own readln function!!!
fun main() {

    while (true) {
        printlnAndLog("Input the action (add, remove, import, export, ask, log, hardest card, reset stats, exit):")
        when (readAndLog()) {
            "add" -> add()
            "remove" -> remove()
            "import" -> import()
            "export" -> export()
            "ask" -> ask()
            "log" -> log()
            //"hardest card" -> hardest_card()
            //"reset stats" -> reset_stats()
            "exit" -> {
                println("Bye bye!")
                break
            }
        }
    }


}
