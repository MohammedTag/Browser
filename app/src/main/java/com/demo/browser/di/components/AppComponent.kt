package com.demo.browser.di.components

import com.demo.browser.MainActivity
import com.demo.browser.di.modules.ContextModule
import com.demo.browser.presentation_layer.fragments.webview.WebViewFragment
import com.demo.browser.presentation_layer.fragments.webview.WebViewViewModelFactoryModule
import dagger.Component
import javax.inject.Singleton


/**
 * Created by Mohammed Sayed Taguldeen on 03,September,2019
 * Cairo, Egypt.
 */
@Singleton
@Component(modules = [
    ContextModule::class,
    WebViewViewModelFactoryModule::class
])
interface AppComponent {

    fun inject(target :MainActivity)

    fun inject (target : WebViewFragment)

}