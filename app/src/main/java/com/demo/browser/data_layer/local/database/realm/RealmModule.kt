package com.demo.browser.data_layer.local.database.realm

import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Mohammed Sayed Taguldeen on 04,September,2019
 * Cairo, Egypt.
 */


@Module
class RealmModule {
    @Singleton
    @Provides
    fun provideDataSource(): DatabaseSource = RealmDataBase()
}