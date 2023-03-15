package kr.co.bullets.didemo

import dagger.Component

@Component(modules = [MemoryCardModule::class, NCBatteryModule::class])
interface SmartPhoneComponent {

//    fun getSmartPhone(): SmartPhone

    fun inject(mainActivity: MainActivity)
}