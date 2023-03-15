package kr.co.bullets.didemo

import dagger.Component

@Component(modules = [MemoryCardModule::class])
interface SmartPhoneComponent {

    fun getSmartPhone(): SmartPhone
}