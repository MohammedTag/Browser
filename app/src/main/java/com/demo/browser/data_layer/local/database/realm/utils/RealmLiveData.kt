package com.demo.browser.data_layer.local.database.realm.utils

import androidx.lifecycle.LiveData
import io.realm.RealmChangeListener
import io.realm.RealmObject


/**
 * Created by Mohammed Sayed Taguldeen on 05,September,2019
 * Cairo, Egypt.
 */


class RealmLiveData<T : RealmObject>(model: T) : LiveData<T>() {

    private val mModel = model
    private val mRealmChangeListener: RealmChangeListener<T> = RealmChangeListener { value = it }


    override fun onActive() {
        super.onActive()
        RealmObject.addChangeListener(mModel, mRealmChangeListener)
    }

    override fun onInactive() {
        super.onInactive()
        RealmObject.removeChangeListener(mModel, mRealmChangeListener)
    }
}