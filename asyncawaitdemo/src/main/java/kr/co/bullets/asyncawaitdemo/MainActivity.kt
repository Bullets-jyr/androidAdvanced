package kr.co.bullets.asyncawaitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        CoroutineScope(IO).launch {
//            Log.i("MYTAG", "Calculation started....")
//            val stock1 = async { getStock1() }
//            val stock2 = async { getStock2() }
//            val total = stock1.await() + stock2.await()
//            Log.i("MYTAG", "Total is $total")
//        }

        CoroutineScope(Main).launch {
            Log.i("MYTAG", "Calculation started....")
            val stock1 = async(IO) { getStock1() }
            val stock2 = async(IO) { getStock2() }
            val total = stock1.await() + stock2.await()
            Toast.makeText(applicationContext, "Total is $total", Toast.LENGTH_LONG).show()
            Log.i("MYTAG", "Total is $total")
        }
    }
}

private suspend fun getStock1(): Int {
    delay(10000)
    Log.i("MYTAG", "stock 1 returned")
    return 55000
}

private suspend fun getStock2(): Int {
    delay(8000)
    Log.i("MYTAG", "stock 2 returned")
    return 35000
}