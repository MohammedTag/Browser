package com.demo.browser.data_layer.local

import androidx.lifecycle.LiveData
import com.demo.browser.data_layer.local.database.realm.utils.RealmResultsLiveData
import com.demo.browser.data_layer.models.SuccessfulUrl


/**
 * Created by Mohammed Sayed Taguldeen on 05,September,2019
 * Cairo, Egypt.
 */
interface LocalDataSource {

    fun addSuccessfulUrl(successfulUrlsList:ArrayList<SuccessfulUrl>)

    fun getUrlSuggestionList(): LiveData<List<SuccessfulUrl>>
}