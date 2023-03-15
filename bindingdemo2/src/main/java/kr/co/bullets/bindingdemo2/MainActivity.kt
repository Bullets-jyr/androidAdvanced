package kr.co.bullets.bindingdemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import kr.co.bullets.bindingdemo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    private lateinit var button: Button

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        setContentView(R.layout.activity_main)
//        button = findViewById(R.id.control_button)
//        button.setOnClickListener {
//            startOrStopProgressBar()
//        }
        binding.controlButton.setOnClickListener {
            startOrStopProgressBar()
        }
    }

    private fun startOrStopProgressBar() {
//        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
//        if (progressBar.visibility == View.GONE) {
//            progressBar.visibility = View.VISIBLE
//            button.text = "Stop"
//        } else {
//            progressBar.visibility = View.GONE
//            button.text = "Start"
//        }
//        if (binding.progressBar.visibility == View.GONE) {
//            binding.progressBar.visibility == View.VISIBLE
//            binding.controlButton.text = "Stop"
//        } else {
//            binding.progressBar.visibility == View.GONE
//            binding.controlButton.text = "Start"
//        }

        binding.apply {
            if (progressBar.visibility == View.GONE) {
                progressBar.visibility = View.VISIBLE
                controlButton.text = "Stop"
            } else {
                progressBar.visibility = View.GONE
                controlButton.text = "Start"
            }
        }
    }
}