package flashcards

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
            "reset stats" -> resetStats()
            "exit" -> {
                printlnAndLog("Bye bye!")
                break
            }
        }
    }
}
