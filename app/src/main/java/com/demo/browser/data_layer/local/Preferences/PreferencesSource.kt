package com.demo.browser.data_layer.local.Preferences

import androidx.lifecycle.LiveData


/**
 * Created by Mohammed Sayed Taguldeen on 05,September,2019
 * Cairo, Egypt.
 */
interface PreferencesSource {
    fun set(key: String, value: String)

    fun get(key: String, defaultValue: String): String


}