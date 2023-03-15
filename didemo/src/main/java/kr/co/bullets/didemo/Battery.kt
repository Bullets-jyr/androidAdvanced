package kr.co.bullets.didemo

import android.util.Log
import javax.inject.Inject

//class Battery @Inject constructor() {
interface Battery {

//    init {
//        Log.i("MYTAG", "Battery Constructed")
//    }

//    fun getPower() {
//        Log.i("MYTAG", "Battery power is available")
//    }

    fun getPower()
}