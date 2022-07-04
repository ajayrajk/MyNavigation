package com.example.mynavigation.retrofit

import com.example.mynavigation.models.QuotesList
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteAPI {

    @GET("Quotes")
    suspend fun getQuotesList(@Query ("page") page :Int): QuotesList

}