package kr.co.bullets.didemoreview

import android.util.Log
import javax.inject.Inject

interface Battery {
//class Battery @Inject constructor() {

//    init {
//        Log.i("MYTAG","Battery Constructed")
//    }

//    fun getPower(){
//        Log.i("MYTAG","Battery power is available")
//    }

    fun getPower()
}