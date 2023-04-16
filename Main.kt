package flashcards


var termDefinition = mutableMapOf<String, String> ()
var cardStatistic = mutableMapOf<String, Int> ()
var log = mutableListOf<String>()

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
            "hardest card" -> hardestCard()
            //"reset stats" -> reset_stats()
            "exit" -> {
                printlnAndLog("Bye bye!")
                break
            }
        }
    }


}
