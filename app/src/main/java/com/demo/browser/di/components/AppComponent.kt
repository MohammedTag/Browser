package com.demo.browser.di.components

import com.demo.browser.MainActivity
import com.demo.browser.data_layer.RepositorySourceModule
import com.demo.browser.data_layer.local.LocalDataSourceModule
import com.demo.browser.data_layer.local.Preferences.PreferencesDataSourceModule
import com.demo.browser.data_layer.local.Preferences.default_perefrences.DefualtPreferenceModule

import com.demo.browser.di.modules.ContextModule
import com.demo.browser.domain_layer.usecases.add_url_use_case.AddUrlsListUseCaseModule
import com.demo.browser.domain_layer.usecases.retrieve_urls_use_case.RetrieveUrlsUseCaseModule
import com.demo.browser.domain_layer.usecases.url_use_case.UrlUseCaseModule
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
    WebViewViewModelFactoryModule::class,
    UrlUseCaseModule::class,
    AddUrlsListUseCaseModule::class,
    RetrieveUrlsUseCaseModule::class,
    RepositorySourceModule::class,
    LocalDataSourceModule::class,
    PreferencesDataSourceModule::class,
    DefualtPreferenceModule::class

])
interface AppComponent {

    fun inject(target :MainActivity)

    fun inject (target : WebViewFragment)

}