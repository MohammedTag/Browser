package com.demo.browser.domain_layer.usecases.retrieve_urls_use_case

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.demo.browser.data_layer.RepositorySource
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Mohammed Sayed Taguldeen on 04,September,2019
 * Cairo, Egypt.
 */


class RetrieveUrlsUseCase @Inject constructor(private val repositorySource: RepositorySource) {



    fun run(): LiveData<List<String>> {
        return repositorySource.getUrlSuggestionList()
    }
}

@Module
class RetrieveUrlsUseCaseModule {

    @Provides
    @Singleton
    fun provideRetrieveUrlsUseCase(repositorySource: RepositorySource) = RetrieveUrlsUseCase(repositorySource)
}