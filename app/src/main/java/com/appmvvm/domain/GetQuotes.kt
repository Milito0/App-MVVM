package com.appmvvm.domain

import com.appmvvm.data.QuoteRepository
import com.appmvvm.data.model.QuoteModel

class GetQuotes {

    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()
}