package com.demo.browser.presentation_layer.fragments.webview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.demo.browser.domain_layer.usecases.url_use_case.UrlUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Mohammed Sayed Taguldeen on 03,September,2019
 * Cairo, Egypt.
 */


class WebViewViewModel(private val urlUserCase: UrlUseCase) : ViewModel() {


   fun urlHandel(url:String): MutableLiveData<String> = urlUserCase.run(url)

}

class WebViewViewModelFactory(private val urlUserCase: UrlUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(WebViewViewModel::class.java))
            return WebViewViewModel(urlUserCase) as T

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

@Module
class WebViewViewModelFactoryModule {
    @Provides
    @Singleton

    fun ProvidesWebViewViewModelFactory(urlUserCase: UrlUseCase): WebViewViewModelFactory = WebViewViewModelFactory(urlUserCase)
}