package domain

import domain.exceptions.NoInternetConnectionException
import domain.exceptions.NonExistingElementException
import ui.PhraseUI

interface CustomExceptionHandler {

    fun handle(e: Exception): PhraseUI

    class Base : CustomExceptionHandler {
        override fun handle(e: Exception): PhraseUI {
            return when (e::class) {
                NoInternetConnectionException::class -> PhraseUI.Failure("No Internet connection")
                NonExistingElementException::class -> PhraseUI.Failure("There is no such element")
                else -> PhraseUI.Failure("something going wrong")
            }
        }
    }

}
