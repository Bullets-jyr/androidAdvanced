package kr.co.bullets.didemoreview

import dagger.Component

@Component(modules = [MemoryCardModule::class, NCBatteryModule::class])
interface SmartPhoneComponent {

    fun getSmartPhone(): SmartPhone
}