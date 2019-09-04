package com.demo.browser.data_layer.local.database.realm

import android.os.Handler
import android.os.Looper
import com.demo.browser.data_layer.local.database.realm.utils.RealmResultsLiveData
import com.demo.browser.data_layer.models.SuccessfulUrl
import io.realm.Realm
import kotlin.concurrent.thread


/**
 * Created by Mohammed Sayed Taguldeen on 04,September,2019
 * Cairo, Egypt.
 */


class RealmDataBase : DatabaseSource {



    override fun addSuccessfulUrl(successfulUrlsList: ArrayList<SuccessfulUrl>) {

            Realm.getDefaultInstance().executeTransactionAsync { it.insertOrUpdate(successfulUrlsList) }

    }

    override fun getUrlSuggestionList(): RealmResultsLiveData<SuccessfulUrl> {

        val threadAccessibleRealmInstance = Realm.getDefaultInstance()
        return RealmResultsLiveData(
            threadAccessibleRealmInstance.where(SuccessfulUrl::class.java)
                .findAllAsync()
        )
    }
}