package com.demo.browser.data_layer.local

import androidx.lifecycle.LiveData
import com.demo.browser.data_layer.local.database.realm.DatabaseSource
import com.demo.browser.data_layer.local.database.realm.utils.RealmResultsLiveData
import com.demo.browser.data_layer.models.SuccessfulUrl
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


/**
 * Created by Mohammed Sayed Taguldeen on 05,September,2019
 * Cairo, Egypt.
 */

class DefaultLocalDataSource constructor(private val databaseSource: DatabaseSource):LocalDataSource{


    override fun getUrlSuggestionList(): LiveData<List<SuccessfulUrl>> = databaseSource.getUrlSuggestionList()


    override fun addSuccessfulUrl(successfulUrlsList: ArrayList<SuccessfulUrl>) = databaseSource.addSuccessfulUrl(successfulUrlsList)



}

@Module
class LocalDataSourceModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(
        databaseSource: DatabaseSource
    ): LocalDataSource =

        DefaultLocalDataSource(databaseSource)
}