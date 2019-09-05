package com.demo.browser.data_layer

import androidx.lifecycle.LiveData
import com.demo.browser.data_layer.models.SuccessfulUrl


/**
 * Created by Mohammed Sayed Taguldeen on 05,September,2019
 * Cairo, Egypt.
 */
interface RepositorySource {
    fun addSuccessfulUrl(successfulUrlsList: String)

    fun getUrlSuggestionList(): LiveData<List<String>>
}