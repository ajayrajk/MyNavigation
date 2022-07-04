package com.example.mynavigation.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.mynavigation.paging.QuotePagingSource
import com.example.mynavigation.retrofit.QuoteAPI
import javax.inject.Inject

class QuoteRepository @Inject constructor (private val quoteAPI: QuoteAPI) {

    fun getQuote()=Pager(config = PagingConfig(pageSize = 20 , maxSize = 100),
          pagingSourceFactory = {QuotePagingSource(quoteAPI)}
        ).liveData
}