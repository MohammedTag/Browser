package com.demo.browser.app

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.demo.browser.di.components.AppComponent
import com.demo.browser.di.components.DaggerAppComponent
import com.demo.browser.di.modules.ContextModule


/**
 * Created by Mohammed Sayed Taguldeen on 03,September,2019
 */


class App: MultiDexApplication() {

    lateinit var context: Context
    lateinit var compnant: AppComponent

    private fun initDagger(appContext: Context): AppComponent =
        DaggerAppComponent.builder()
            .contextModule(ContextModule(appContext))
            .build()


    override fun onCreate() {
        super.onCreate()

        context = this
        compnant = initDagger(this.applicationContext)
    }
}
