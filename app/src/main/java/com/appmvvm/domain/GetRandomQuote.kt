package com.appmvvm.domain

import com.appmvvm.data.model.QuoteModel
import com.appmvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuote @Inject constructor(
    private val quoteProvider: QuoteProvider
){
    operator fun invoke():QuoteModel?{
        val quotes = quoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            return quotes[quotes.indices.random()]
        }
        return null
    }
}