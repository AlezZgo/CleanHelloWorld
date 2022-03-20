package data

import domain.exceptions.NonExistingElementException

interface CacheDataSource {

    fun name(): String

    class Base() : CacheDataSource {
        override fun name(): String {
            try {
                return "Hello"
            } catch (e: Exception) {
                throw NonExistingElementException()
            }
        }
    }

    class Base2() : CacheDataSource {
        override fun name(): String {
            try {
                return "Zdravstvui"
            } catch (e: Exception) {
                throw NonExistingElementException()
            }
        }
    }


}
