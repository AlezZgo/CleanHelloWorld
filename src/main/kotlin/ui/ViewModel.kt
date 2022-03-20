package ui

import data.CacheDataSource
import data.CloudDataSource
import data.Repository
import domain.CustomExceptionHandler
import domain.Interactor

class ViewModel {

    private val cacheDataSource = CacheDataSource.Base()
    private val cloudDataSource = CloudDataSource.Base()

    private val repository = Repository.Base(cacheDataSource, cloudDataSource)
    private val handler = CustomExceptionHandler.Base()

    private val interactor = Interactor.Base(repository, handler)

    fun start() {
        interactor.fetchMessage().show()
    }


}