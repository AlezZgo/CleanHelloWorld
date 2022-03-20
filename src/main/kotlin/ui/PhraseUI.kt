package ui

abstract class PhraseUI {
    abstract fun show()

    data class Success(private val name: String, private val surName: String) : PhraseUI() {
        override fun show() {
            "$name $surName".forEach {
                print(it)
                Thread.sleep(250)
            }

        }
    }

    data class Failure(private val message: String) : PhraseUI() {
        override fun show() {
            message.forEach {
                print(it)
                Thread.sleep(100)
            }

        }

    }
}
