package kr.co.bullets.didemoreview

import dagger.Component

@Component(modules = [MemoryCardModule::class])
interface SmartPhoneComponent {

    fun getSmartPhone(): SmartPhone
}