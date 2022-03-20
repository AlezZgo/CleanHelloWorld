package domain

import data.Repository
import ui.PhraseUI

interface Interactor {

    fun fetchMessage(): PhraseUI

    class Base(private val repository: Repository, private val handler: CustomExceptionHandler) : Interactor {
        override fun fetchMessage(): PhraseUI {

            return try {
                repository.fetchMessage().toUI()
            } catch (e: Exception) {
                handler.handle(e)
            }
        }
    }
}