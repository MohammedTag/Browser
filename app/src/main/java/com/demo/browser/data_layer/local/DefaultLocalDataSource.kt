package com.demo.browser.data_layer.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.demo.browser.data_layer.local.Preferences.PreferencesConstants
import com.demo.browser.data_layer.local.Preferences.PreferencesConstants.PreferencesKeys.USER_SUCCESSFUL_URL_HISTORY
import com.demo.browser.data_layer.local.Preferences.PreferencesSource
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


/**
 * Created by Mohammed Sayed Taguldeen on 05,September,2019
 * Cairo, Egypt.
 */
class DefaultLocalDataSource constructor(private val mPreferencesDataSource: PreferencesSource) : LocalDataSource {

    /** shared prefrences is used for simplicity*/

    val urlsListAsLiveData = MutableLiveData<List<String>>()
    override fun addSuccessfulUrl(successfulUrlsList: String) {
        mPreferencesDataSource.set(USER_SUCCESSFUL_URL_HISTORY, successfulUrlsList)
    }

    override fun getUrlSuggestionList(): LiveData<List<String>> {
        val csvList = mPreferencesDataSource.get(USER_SUCCESSFUL_URL_HISTORY, "")
        urlsListAsLiveData.value = csvList?.split(",")
        return urlsListAsLiveData
    }


}

@Module
class LocalDataSourceModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(

        @Named(value = PreferencesConstants.DaggerNamedValues.PREFERENCE_SOURCE)
        preferencesSource: PreferencesSource
    ): LocalDataSource =

        DefaultLocalDataSource(preferencesSource)
}