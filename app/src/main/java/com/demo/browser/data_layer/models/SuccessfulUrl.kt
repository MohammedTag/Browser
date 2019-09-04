package com.demo.browser.data_layer.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass


/**
 * Created by Mohammed Sayed Taguldeen on 04,September,2019
 * Cairo, Egypt.
 */

open class SuccessfulUrl :RealmObject(){

    @PrimaryKey
    var Url:String? =null

}