package com.appmvvm.data

import com.appmvvm.data.database.dao.QuoteDao
import com.appmvvm.data.database.entities.QuoteEntity
import com.appmvvm.data.model.QuoteModel
import com.appmvvm.data.network.QuoteService
import com.appmvvm.ui.domain.model.Quote
import com.appmvvm.ui.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api : QuoteService,
    private val quoteDao: QuoteDao
){
    suspend fun getAllQuotesFromApi(): List<Quote> {
        return api.getQuotes().map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDB(): List<Quote>{
        val response = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}