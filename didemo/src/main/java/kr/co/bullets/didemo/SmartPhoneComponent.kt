package kr.co.bullets.didemo

import dagger.Component

@Component
interface SmartPhoneComponent {

    fun getSmartPhone(): SmartPhone
}