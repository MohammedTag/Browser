package com.demo.browser.domain_layer.usecases.retrieve_urls_use_case

import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Mohammed Sayed Taguldeen on 04,September,2019
 * Cairo, Egypt.
 */


class RetrieveUrlsUseCase {



    /*  fun run(urlText: String): MutableLiveData<String> {
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
      }*/
}

@Module
class RetrieveUrlsUseCaseModule {

    @Provides
    @Singleton
    fun provideRetrieveUrlsUseCase(/*searchRepository: SearchRepository*/) = RetrieveUrlsUseCase(/*searchRepository*/)
}