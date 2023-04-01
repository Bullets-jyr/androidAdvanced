package kr.co.bullets.didemoreview

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
// This smartphone class has 3 direct dipendencies.
// For this scenario , SmartPhone is the dependent. Battery , Memeroy card and Sim Card are dependencies.
class SmartPhone @Inject constructor(val battery: Battery, val simCard: SIMCard, val memoryCard: MemoryCard) {
    init {
        Log.i("MYTAG", "SmartPhone Constructed")
        battery.getPower()
        simCard.getConnection()
        memoryCard.getSpaceAvailablity()
    }

    fun makeACallWithRecording() {
        Log.i("MYTAG", "Calling.....")
    }
}