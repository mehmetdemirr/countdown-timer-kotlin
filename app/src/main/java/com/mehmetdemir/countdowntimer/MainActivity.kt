package com.mehmetdemir.countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.mehmetdemir.countdowntimer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var tasarim:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim= DataBindingUtil.setContentView(this,R.layout.activity_main)
        tasarim.textView2.text="Başlatılmadı!"

        tasarim.button.setOnClickListener {
            tasarim.button.visibility= View.INVISIBLE
            val sayici=object:CountDownTimer(30000,1000){
                override fun onTick(p0: Long) {
                    tasarim.textView2.text="Kalan Süre:${p0/1000}"
                }

                override fun onFinish() {
                    tasarim.textView2.text="Bitti"
                    tasarim.button.visibility=View.VISIBLE
                }
            }
            sayici.start()
        }
    }
}