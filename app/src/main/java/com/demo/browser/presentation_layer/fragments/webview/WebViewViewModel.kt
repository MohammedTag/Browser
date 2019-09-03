package com.demo.browser.presentation_layer.fragments.webview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Mohammed Sayed Taguldeen on 03,September,2019
 * Cairo, Egypt.
 */


class WebViewViewModel(/*private val performanceUseCase: PerformanceUseCase*/) : ViewModel() {


}

class WebViewViewModelFactory(/*private val performanceUseCase: PerformanceUseCase*/) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(WebViewViewModel::class.java))
            return WebViewViewModel(/*performanceUseCase*/) as T

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

@Module
class WebViewViewModelFactoryModule {
    @Provides
    @Singleton

    fun ProvidesWebViewViewModelFactory(/*performanceUseCase: PerformanceUseCase*/): WebViewViewModelFactory = WebViewViewModelFactory(/*performanceUseCase*/)
}