package domain

import domain.exceptions.NoInternetConnectionException
import domain.exceptions.NonExistingElementException
import ui.PhraseUI
import kotlin.test.assertEquals


class CustomExceptionHandlerTest {

    fun handle_no_internet_exception(){
        val noConnException : Exception = NoInternetConnectionException()
        val actual = CustomExceptionHandler.Base().handle(noConnException)
        assertEquals(PhraseUI.Failure("No Internet connection"),actual)
    }

    fun handle_no_such_element_exception(){
        val noSuchElemException: Exception = NonExistingElementException()
        val actual = CustomExceptionHandler.Base().handle(noSuchElemException)
        assertEquals(PhraseUI.Failure("There is no such element"),actual)
    }

    fun handle_unknown_exception(){
        val exc = Exception()
        val actual = CustomExceptionHandler.Base().handle(exc)
        assertEquals(PhraseUI.Failure("something going wrong"),actual)
    }
}