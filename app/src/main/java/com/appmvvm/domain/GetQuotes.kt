package com.appmvvm.domain

import com.appmvvm.data.QuoteRepository
import com.appmvvm.data.model.QuoteModel
import javax.inject.Inject


class GetQuotes @Inject constructor(
    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()
}