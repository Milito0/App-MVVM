package com.appmvvm.ui.domain

import com.appmvvm.data.QuoteRepository
import com.appmvvm.data.database.entities.toDatabase
import com.appmvvm.data.model.QuoteModel
import com.appmvvm.ui.domain.model.Quote
import javax.inject.Inject


class GetQuotes @Inject constructor(
    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): List<Quote>{
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else{
            return repository.getAllQuotesFromDB()
        }
    }
}