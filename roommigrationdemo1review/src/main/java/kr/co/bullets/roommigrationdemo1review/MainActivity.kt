package kr.co.bullets.roommigrationdemo1review

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dao = StudentDatabase.getInstance(application).subscriberDAO

        val nameEditText = findViewById<EditText>(R.id.etName)
        val emailEditText = findViewById<EditText>(R.id.etEmail)
        val courseEditText = findViewById<EditText>(R.id.etCourse)
        val button = findViewById<Button>(R.id.btnSubmit)

        button.setOnClickListener {
            lifecycleScope.launch {
                nameEditText.text.let {
                    dao.insertStudent(Student(0, it.toString(), emailEditText.text.toString(), courseEditText.text.toString()))
                    nameEditText.setText("")
                    emailEditText.setText("")
                    courseEditText.setText("")
                }
            }
        }
    }
}