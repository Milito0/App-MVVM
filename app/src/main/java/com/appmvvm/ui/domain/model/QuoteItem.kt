package com.appmvvm.ui.domain.model

import com.appmvvm.data.database.entities.QuoteEntity
import com.appmvvm.data.model.QuoteModel

data class Quote(val quote:String, val author:String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)
