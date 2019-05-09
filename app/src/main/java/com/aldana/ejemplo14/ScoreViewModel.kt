package com.aldana.ejemplo14

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel() : ViewModel() {
    var scoreTeamA = 0
    var scoreTeamB = 0

    @Bindable
    val pointA = MutableLiveData<Int>()
    @Bindable
    val pointB = MutableLiveData<Int>()

    fun saveScore(){
        pointA.value = scoreTeamA
        pointB.value = scoreTeamB
    }


}