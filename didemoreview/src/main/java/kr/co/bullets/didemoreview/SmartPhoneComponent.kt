package kr.co.bullets.didemoreview

import dagger.Component

@Component
interface SmartPhoneComponent {

    fun getSmartPhone(): SmartPhone
}