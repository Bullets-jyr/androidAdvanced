package kr.co.bullets.didemoreview

import android.app.Application

class SmartPhoneApplication : Application() {

    lateinit var smartPhoneComponent: SmartPhoneComponent

    override fun onCreate() {
        smartPhoneComponent = initDagger()
        super.onCreate()
    }

    private fun initDagger(): SmartPhoneComponent {
        return DaggerSmartPhoneComponent.builder()
            .memoryCardModule(MemoryCardModule(1000))
            .build()
    }
}