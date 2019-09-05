package com.demo.browser.presentation_layer.fragments.webview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.demo.browser.data_layer.models.SuccessfulUrl
import com.demo.browser.domain_layer.usecases.add_url_use_case.AddUrlsListUseCase
import com.demo.browser.domain_layer.usecases.retrieve_urls_use_case.RetrieveUrlsUseCase
import com.demo.browser.domain_layer.usecases.url_use_case.UrlUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Mohammed Sayed Taguldeen on 03,September,2019
 * Cairo, Egypt.
 */


class WebViewViewModel(
    private val urlUserCase: UrlUseCase,
    private val addUrlsListUseCase: AddUrlsListUseCase,
    private val retrieveUrlsUseCase: RetrieveUrlsUseCase
) :
    ViewModel() {


    fun urlHandel(url: String): MutableLiveData<String> = urlUserCase.run(url)
    fun saveSuccessfulUrlList(successfulUrlsList: String) = addUrlsListUseCase.run(successfulUrlsList)
    fun retrieveUrlsList() : LiveData<List<String>> = retrieveUrlsUseCase.run()

}

class WebViewViewModelFactory(
    private val urlUserCase: UrlUseCase,
    private val addUrlsListUseCase: AddUrlsListUseCase,
    private val retrieveUrlsUseCase: RetrieveUrlsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(WebViewViewModel::class.java))
            return WebViewViewModel(urlUserCase, addUrlsListUseCase, retrieveUrlsUseCase) as T

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

@Module
class WebViewViewModelFactoryModule {
    @Provides
    @Singleton

    fun ProvidesWebViewViewModelFactory(
        urlUserCase: UrlUseCase,
        addUrlsListUseCase: AddUrlsListUseCase,
        retrieveUrlsUseCase: RetrieveUrlsUseCase
    ): WebViewViewModelFactory =
        WebViewViewModelFactory(urlUserCase, addUrlsListUseCase, retrieveUrlsUseCase)
}