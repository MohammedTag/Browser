package com.demo.browser.data_layer.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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


    private var  list2 = MutableLiveData<List<String>>()
    var list = ArrayList<String>()
    override fun getUrlSuggestionList(): LiveData<List<String>> {
        val list1 = databaseSource.getUrlSuggestionList()
        list1.value?.lastIndex?.let {
            for (i in 0..it){

                list1.value?.get(i)?.Url?.let {list.add(it)}
            }
        }
        list2.value = list
        return  list2
    }


    override fun addSuccessfulUrl(successfulUrlsList: SuccessfulUrl) = databaseSource.addSuccessfulUrl(successfulUrlsList)



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