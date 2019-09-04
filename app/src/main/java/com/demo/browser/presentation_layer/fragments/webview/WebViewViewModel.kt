package com.demo.browser.presentation_layer.fragments.webview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.demo.browser.data_layer.models.SuccessfulUrl
import com.demo.browser.domain_layer.usecases.add_url_use_case.AddUrlsListUseCase
import com.demo.browser.domain_layer.usecases.url_use_case.UrlUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Mohammed Sayed Taguldeen on 03,September,2019
 * Cairo, Egypt.
 */


class WebViewViewModel(private val urlUserCase: UrlUseCase, private val addUrlsListUseCase: AddUrlsListUseCase) :
    ViewModel() {


    fun urlHandel(url: String): MutableLiveData<String> = urlUserCase.run(url)
    fun saveSuccessfulUrlList(successfulUrlsList: ArrayList<SuccessfulUrl>) = addUrlsListUseCase.run(successfulUrlsList)

}

class WebViewViewModelFactory(private val urlUserCase: UrlUseCase,private val addUrlsListUseCase: AddUrlsListUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(WebViewViewModel::class.java))
            return WebViewViewModel(urlUserCase,addUrlsListUseCase) as T

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

@Module
class WebViewViewModelFactoryModule {
    @Provides
    @Singleton

    fun ProvidesWebViewViewModelFactory(urlUserCase: UrlUseCase,addUrlsListUseCase: AddUrlsListUseCase): WebViewViewModelFactory =
        WebViewViewModelFactory(urlUserCase,addUrlsListUseCase)
}