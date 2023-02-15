package flashcards

import flashcards.add as add


fun main() {

    while (true) {
        println("Input the action (add, remove, import, export, ask, exit):")
        when (readln()) {
            "add" -> add("/Users/kirilllemesev/IdeaProjects/Flashcards/Flashcards/task/src/flashcards/cards.txt")
            "remove" -> // TODO
            "import" -> // TODO
            "export" -> // TODO
            "ask" -> // TODO
            "exit" -> // TODO
        }
    }


}