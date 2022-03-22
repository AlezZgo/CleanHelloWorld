package data

import domain.exceptions.NoInternetConnectionException

interface CloudDataSource {

    fun surname(): String

    class Base() : CloudDataSource {
        override fun surname(): String {
            try {
                return "World!"
            } catch (e: Exception) {
                throw NoInternetConnectionException()
            }
        }
    }

    class Base2() : CloudDataSource {
        override fun surname(): String {
            try {
                return "Universe!"
            } catch (e: Exception) {
                throw NoInternetConnectionException()
            }
        }

    }

    class Test() : CloudDataSource {
        override fun surname(): String {
            throw NoInternetConnectionException()
        }

    }
}
