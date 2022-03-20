package data

import domain.PhraseDomain

interface Repository {

    fun fetchMessage(): PhraseDomain

    class Base(
        private val cacheDataSource: CacheDataSource,
        private val cloudDataSource: CloudDataSource
    ) : Repository {

        override fun fetchMessage(): PhraseDomain {
            return PhraseDomain(cacheDataSource.name(), cloudDataSource.surname())
        }
    }
}