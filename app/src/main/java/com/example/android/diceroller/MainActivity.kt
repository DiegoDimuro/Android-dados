package com.example.android.diceroller

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.tirar_button)
        rollButton.setOnClickListener {
            tirarDado()
            val mp = MediaPlayer.create(this, R.raw.roll);
            mp.start();

        }
    }

    private fun tirarDado() {
        val reultText1: TextView = findViewById(R.id.resultado_texto1)
        val reultText2: TextView = findViewById(R.id.resultado_texto2)
        val randomInt1 = Random.nextInt(6) + 1
        val randomInt2 = Random.nextInt(6) + 1
        reultText1.text = randomInt1.toString()
        reultText2.text = randomInt2.toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}