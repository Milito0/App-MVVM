package com.appmvvm.ui.domain

import com.appmvvm.data.QuoteRepository
import com.appmvvm.data.model.QuoteModel
import com.appmvvm.ui.domain.model.Quote
import javax.inject.Inject

class GetRandomQuote @Inject constructor(
    private val repository: QuoteRepository
){
    operator suspend fun invoke(): Quote?{
        val quotes = repository.getAllQuotesFromDB()
        if(!quotes.isNullOrEmpty()){
            return quotes[quotes.indices.random()]
        }
        return null
    }
}