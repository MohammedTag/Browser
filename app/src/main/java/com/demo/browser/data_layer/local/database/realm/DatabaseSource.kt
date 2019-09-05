package com.demo.browser.data_layer.local.database.realm

import com.demo.browser.data_layer.local.database.realm.utils.RealmResultsLiveData
import com.demo.browser.data_layer.models.SuccessfulUrl
import io.realm.RealmList
import java.net.URL


/**
 * Created by Mohammed Sayed Taguldeen on 04,September,2019
 * Cairo, Egypt.
 */
interface DatabaseSource {


    //region database

    fun addSuccessfulUrl(successfulUrlsList: SuccessfulUrl)

    fun getUrlSuggestionList(): RealmResultsLiveData<SuccessfulUrl>

    //endregion
}