package com.aldana.ejemplo14

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel() : ViewModel() {
    var scoreTeamA = 0
    var scoreTeamB = 0

    @Bindable
    val contenidoPuntajeA = MutableLiveData<Int>()
    @Bindable
    val contenidoPuntajeB = MutableLiveData<Int>()

    fun onNewScore(){
        contenidoPuntajeA.value = scoreTeamA
        contenidoPuntajeB.value = scoreTeamB
    }

}