package com.demo.browser.data_layer.local.Preferences.default_perefrences

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.lifecycle.LiveData
import com.demo.browser.data_layer.local.Preferences.PreferencesConstants
import com.demo.browser.data_layer.local.Preferences.PreferencesSource
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


/**
 * Created by Mohammed Sayed Taguldeen on 05,September,2019
 * Cairo, Egypt.
 */

class DefaultPreference constructor(private val mSharedPreferences: SharedPreferences): PreferencesSource {
    override fun set(key: String, value: String) = mSharedPreferences.edit().putString(key, value).apply()

    override fun get(key: String, defaultValue: String) = mSharedPreferences.getString(key, defaultValue)!!


}


@Module
class DefualtPreferenceModule {

    @Singleton
    @Provides
    fun providesDefualtPreference(appContext: Context): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(appContext)

    @Named(value = PreferencesConstants.DaggerNamedValues.DEFAULT_PREFERENCE)
    @Singleton
    @Provides
    fun providesEncryptedPreferences(sharedPreferences: SharedPreferences): PreferencesSource = DefaultPreference(sharedPreferences)

}