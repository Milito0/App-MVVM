package com.appmvvm.data.network

import com.appmvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.jason")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}