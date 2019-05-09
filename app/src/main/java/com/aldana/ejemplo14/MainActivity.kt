package com.aldana.ejemplo14

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.aldana.ejemplo14.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main
        ).apply {
            this.lifecycleOwner = this@MainActivity
            this.points = scoreViewModel
        }

        scoreViewModel.pointA.observe(this, Observer {
            tv_score_team_a.text = it.toString()
        })

        scoreViewModel.pointB.observe(this, Observer {
            tv_score_team_b.text = it.toString()
        })

        // TODO: El ViewModel es restaurado si ya existía, si no, se crea uno nuevo.
        // TODO: Recuerde que el ViewModel solo sobrevive a cambios de configuración y no a la destrucción de la aplicación

    }


    // TODO: Accediendo y modificando datos almacenados en el ViewModel según el método utilizado

    fun addOneTeamA(v: View) {
        scoreViewModel.scoreTeamA += 1
        scoreViewModel.saveScore()
    }

    fun addOneTeamB(v: View) {
        scoreViewModel.scoreTeamB += 1
        scoreViewModel.saveScore()
    }

    fun addTwoTeamA(v: View) {
        scoreViewModel.scoreTeamA += 2
        scoreViewModel.saveScore()
    }

    fun addTwoTeamB(v: View) {
        scoreViewModel.scoreTeamB += 2
        scoreViewModel.saveScore()
    }

    fun addThreeTeamA(v: View) {
        scoreViewModel.scoreTeamA += 3
        scoreViewModel.saveScore()
    }

    fun addThreeTeamB(v: View) {
        scoreViewModel.scoreTeamB += 3
        scoreViewModel.saveScore()
    }

    fun resetScores(v: View) {
        scoreViewModel.scoreTeamA = 0
        scoreViewModel.scoreTeamB = 0

        scoreViewModel.saveScore()
    } // TODO: Limpiando datos


}
