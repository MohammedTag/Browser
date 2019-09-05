package com.demo.browser.data_layer.local.Preferences

import com.demo.browser.data_layer.local.Preferences.default_perefrences.DefualtPreferenceModule
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


/**
 * Created by Mohammed Sayed Taguldeen on 05,September,2019
 * Cairo, Egypt.
 */
class PreferencesDataSource constructor(private val mDefaultPreference: PreferencesSource):PreferencesSource{
    override fun get(key: String, defaultValue: String) = mDefaultPreference.get(key, defaultValue)
    override fun set(key: String, value: String)= mDefaultPreference.set(key, value)

}



@Module(includes = [
    DefualtPreferenceModule::class
])
class PreferencesDataSourceModule {

    @Named(value = PreferencesConstants.DaggerNamedValues.PREFERENCE_SOURCE)
    @Singleton
    @Provides
    fun providePreferencesDataSource(
        @Named(value = PreferencesConstants.DaggerNamedValues.DEFAULT_PREFERENCE)
        defaultPreferencesSource: PreferencesSource): PreferencesSource = PreferencesDataSource(defaultPreferencesSource)
}