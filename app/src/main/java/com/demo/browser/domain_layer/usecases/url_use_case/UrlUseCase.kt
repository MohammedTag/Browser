package com.demo.browser.domain_layer.usecases.url_use_case

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Mohammed Sayed Taguldeen on 03,September,2019
 * Cairo, Egypt.
 */

class UrlUseCase {

    fun run(urlText: String): MutableLiveData<String> {


        if (Patterns.WEB_URL.matcher(urlText.toLowerCase()).matches()) return MutableLiveData<String>().apply {
            if (urlText.contains("http://") || urlText.contains("https://")) {
                this.value = urlText
            } else {
                this.value = "http://$urlText"
            }
        }
        else return MutableLiveData<String>().apply {
            value = "https://www.google.com/search?q=$urlText"
        }


    }
}

@Module
class UrlUseCaseModule {

    @Provides
    @Singleton
    fun provideUrlUseCase(/*searchRepository: SearchRepository*/) = UrlUseCase(/*searchRepository*/)
}