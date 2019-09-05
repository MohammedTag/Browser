package com.demo.browser.data_layer

import androidx.lifecycle.LiveData
import com.demo.browser.data_layer.local.LocalDataSource
import com.demo.browser.data_layer.local.LocalDataSourceModule
import com.demo.browser.data_layer.models.SuccessfulUrl
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Mohammed Sayed Taguldeen on 05,September,2019
 * Cairo, Egypt.
 */

class DataSource @Inject constructor(private val localDataSource: LocalDataSource) : RepositorySource {
    override fun getUrlSuggestionList(): LiveData<List<String>> {
       return localDataSource.getUrlSuggestionList()
    }

    override fun addSuccessfulUrl(successfulUrlsList: String) {
        localDataSource.addSuccessfulUrl(successfulUrlsList)
    }

}

@Module(includes = [
    LocalDataSourceModule::class])
class RepositorySourceModule {

    @Provides
    @Singleton
    fun provideRepositorySource(localDataSource: LocalDataSource): RepositorySource =
        DataSource(localDataSource)
}