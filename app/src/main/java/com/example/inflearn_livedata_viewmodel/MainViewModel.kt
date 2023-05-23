package com.example.inflearn_livedata_viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap

class MainViewModel : ViewModel() {
    private var _word = MutableLiveData<String>()
    val word : LiveData<String>
        get() = _word

    private var _randomWord = MutableLiveData<String>()
    val randomWord : LiveData<String>
        get() = _randomWord

    val randomWord2 = word.switchMap { wordValue ->
        getShuffleWord(wordValue)
    }

    init{
        getNextWord()
    }

    fun getNextWord() {
        val currentWord = WordData.wordDataList.random()
        _word.value = currentWord

        val randomCurrentWord = currentWord.toCharArray()
        randomCurrentWord.shuffle()
        _randomWord.value = String(randomCurrentWord)
    }

    fun getShuffleWord(word : String) : MutableLiveData<String> {

        val mutableLiveData = MutableLiveData("")

        val randomWord = word.toCharArray()
        randomWord.shuffle()

        mutableLiveData.value = String(randomWord)

        return mutableLiveData
    }
}