package flashcards

fun main(args: Array<String>) {

    if ("-import" in args) {
        val fileIndex = args.indexOf("-import") + 1
        val filePath = args[fileIndex]
        import(filePath)
    }

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
                if ("-export" in args) {
                    val fileIndex = args.indexOf("-export") + 1
                    val filePath = args[fileIndex]
                    export(filePath)
                }
                break
            }
        }
    }
}
