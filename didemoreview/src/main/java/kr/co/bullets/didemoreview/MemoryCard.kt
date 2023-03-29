package kr.co.bullets.didemoreview

import android.util.Log
import javax.inject.Inject

class MemoryCard {
//class MemoryCard @Inject constructor() {
    init {
        Log.i("MYTAG","Memory Card Constructed")
    }

    fun getSpaceAvailablity(){
        Log.i("MYTAG","Memory space available")
    }
}