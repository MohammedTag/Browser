package com.demo.browser.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Mohammed Sayed Taguldeen on 03,September,2019
 * Cairo, Egypt.
 */

@Module
class ContextModule(private val appContext: Context) {

    @Provides
    @Singleton
    fun provideContext() = appContext
}