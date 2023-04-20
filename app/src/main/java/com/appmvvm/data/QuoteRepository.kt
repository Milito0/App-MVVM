package com.appmvvm.data

import com.appmvvm.data.model.QuoteModel
import com.appmvvm.data.model.QuoteProvider
import com.appmvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api : QuoteService,
    private val quoteProvider: QuoteProvider
){
    suspend fun getAllQuotes(): List<QuoteModel> {
        quoteProvider.quotes = api.getQuotes()
        return quoteProvider.quotes
    }
}