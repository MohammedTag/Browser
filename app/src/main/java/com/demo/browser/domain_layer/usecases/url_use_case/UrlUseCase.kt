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

    var string1 = MutableLiveData<String>()

    fun run(urlText: String): MutableLiveData<String> {
        if (Patterns.WEB_URL.matcher(urlText.toLowerCase()).matches()) {
            if (urlText.contains("http://") || urlText.contains("https://")) {
                this.string1.value = urlText
                return string1
            } else {
                string1.value = "http://$urlText"
                return string1
            }
        } else MutableLiveData<String>().apply {
            string1.value = "https://www.google.com/search?q=$urlText"
            return string1
        }
    }
}

@Module
class UrlUseCaseModule {

    @Provides
    @Singleton
    fun provideUrlUseCase() = UrlUseCase()
}