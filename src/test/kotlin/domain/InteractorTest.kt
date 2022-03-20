package domain

import data.Repository
import domain.exceptions.NoInternetConnectionException
import domain.exceptions.NonExistingElementException
import ui.PhraseUI
import kotlin.test.assertEquals

class InteractorTest {

    fun fetch_message_with_no_exception() {
        val repository = TestRepository()
        val handler = TestHandler()

        val actual = Interactor.Base(repository,handler).fetchMessage()
        val expected = PhraseUI.Success("John", "Mill")
        assertEquals(expected,actual)
    }

    fun fetch_message_with_cloud_exception() {
        val repository = TestRepositoryWithCloudException()
        val handler = TestHandler()

        val actual = Interactor.Base(repository,handler).fetchMessage()
        val expected = PhraseUI.Failure("something going wrong")
        assertEquals(expected,actual)
    }
}

class TestHandler : CustomExceptionHandler {
    override fun handle(e: Exception): PhraseUI {
        return PhraseUI.Failure("something going wrong")
    }
}

class TestRepository : Repository {
    override fun fetchMessage(): PhraseDomain {
        return PhraseDomain("John", "Mill")
    }
}

class TestRepositoryWithCloudException : Repository {
    override fun fetchMessage(): PhraseDomain {
        throw NoInternetConnectionException()
    }
}

class TestRepositoryWithCacheException : Repository {
    override fun fetchMessage(): PhraseDomain {
        throw NonExistingElementException()
    }
}

class TestRepositoryUnknownException : Repository {
    override fun fetchMessage(): PhraseDomain {
        throw Exception()
    }
}