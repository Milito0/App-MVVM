package com.appmvvm.data

import com.appmvvm.data.model.QuoteModel
import com.appmvvm.data.model.QuoteProvider
import com.appmvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        QuoteProvider.quotes = api.getQuotes()
        return QuoteProvider.quotes
    }
}