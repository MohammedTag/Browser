package com.demo.browser.domain_layer.usecases.add_url_use_case

import com.demo.browser.data_layer.RepositorySource
import com.demo.browser.data_layer.models.SuccessfulUrl
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Mohammed Sayed Taguldeen on 04,September,2019
 * Cairo, Egypt.
 */

class AddUrlsListUseCase @Inject constructor( private  val repositorySource: RepositorySource){



   fun run(successfulUrlsList: String) {
       repositorySource.addSuccessfulUrl(successfulUrlsList)
    }
}

@Module
class AddUrlsListUseCaseModule {

    @Provides
    @Singleton
    fun provideAddUrlsListUseCase( repositorySource: RepositorySource) = AddUrlsListUseCase(repositorySource)
}