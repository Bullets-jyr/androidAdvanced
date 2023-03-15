package kr.co.bullets.bindingdemo3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import kr.co.bullets.bindingdemo3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.student = getStudent()
//        val student = getStudent()
//        binding.nameText.text = student.name
//        binding.emailText.text = student.email
    }

    private fun getStudent(): Student {
        return Student(1,"Alex","alex@gmail.com")
    }
}