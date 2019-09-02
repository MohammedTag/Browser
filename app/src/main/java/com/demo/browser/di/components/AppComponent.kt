package com.demo.browser.di.components

import com.demo.browser.MainActivity
import com.demo.browser.di.modules.ContextModule
import dagger.Component
import javax.inject.Singleton


/**
 * Created by Mohammed Sayed Taguldeen on 03,September,2019
 * Cairo, Egypt.
 */
@Singleton
@Component(modules = [
    ContextModule::class
])
interface AppComponent {

    fun inject(target :MainActivity)

}