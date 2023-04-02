package kr.co.bullets.didemoreview

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

// annotate it with Singleton annotation.
// Now, Since we have annotated this class with the singleton annotation, We have to also annotate its component interface with the singleton annotation.
@Singleton
// This smartphone class has 3 direct dipendencies.
// For this scenario, SmartPhone is the dependent. Battery , Memeroy card and Sim Card are dependencies.
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