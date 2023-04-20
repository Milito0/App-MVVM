package com.appmvvm.data.model

import com.google.gson.annotations.SerializedName

data class QuoteModel(
    @SerializedName("author") val author: String,
    @SerializedName("quote") val quote: String
)