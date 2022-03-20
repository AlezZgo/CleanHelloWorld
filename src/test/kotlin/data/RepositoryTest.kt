package data

import domain.exceptions.NoInternetConnectionException
import kotlin.test.assertEquals


class RepositoryTest {

    fun fetch_message_with_no_exception() {
        val cacheDataSource = TestCacheDataSource()
        val cloudDataSource = TestCloudDataSource()

        assertEquals("John Mill","$cacheDataSource $cloudDataSource")
    }

    fun fetch_message_with_cloud_exception() {
        val cacheDataSource = TestCacheDataSourceWithException()
        val cloudDataSource = TestCloudDataSourceWithException()
    }

    fun fetch_message_with_cache_exception() {
        val cacheDataSource = TestCacheDataSourceWithException()
        val cloudDataSource = TestCloudDataSourceWithException()
    }

    class TestCacheDataSource(): CacheDataSource{
        override fun name(): String = "John"
    }
    class TestCloudDataSource(): CloudDataSource{
        override fun surname(): String = "Mill"
    }
    class TestCacheDataSourceWithException(): CacheDataSource{
        override fun name(): String = throw NoInternetConnectionException()
    }
    class TestCloudDataSourceWithException(): CloudDataSource{
        override fun surname(): String = throw NoInternetConnectionException()
    }

}