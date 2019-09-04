package com.demo.browser.data_layer.local.database.realm.utils

import androidx.lifecycle.LiveData
import io.realm.RealmChangeListener
import io.realm.RealmObject
import io.realm.RealmResults


/**
 * Created by Mohammed Sayed Taguldeen on 04,September,2019
 * Cairo, Egypt.
 */

class RealmResultsLiveData<T : RealmObject>(results: RealmResults<T>) : LiveData<List<T>>() {

    private val mResults = results
    private val mRealmChangeListener: RealmChangeListener<RealmResults<T>> = RealmChangeListener { value = it }

    override fun onActive() {
        super.onActive()
        mResults.addChangeListener(mRealmChangeListener)
    }

    override fun onInactive() {
        super.onInactive()
        mResults.removeChangeListener(mRealmChangeListener)
    }
}