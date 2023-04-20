package com.appmvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appmvvm.data.model.QuoteModel
import com.appmvvm.domain.GetQuotes
import com.appmvvm.domain.GetRandomQuote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotes: GetQuotes,
    private val getRandomQuote: GetRandomQuote
): ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotes()

            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }else{
                Log.i("Milito", result.isNullOrEmpty().toString())
            }
        }
    }

    fun randomQuote(){
        isLoading.postValue(true)

        val quote = getRandomQuote()
        if(quote!=null) quoteModel.postValue(quote)
        isLoading.postValue(false)
    }


}