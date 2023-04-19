package com.appmvvm.domain

import com.appmvvm.data.model.QuoteModel
import com.appmvvm.data.model.QuoteProvider

class GetRandomQuote {
    operator fun invoke():QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            return quotes[quotes.indices.random()]
        }
        return null
    }
}