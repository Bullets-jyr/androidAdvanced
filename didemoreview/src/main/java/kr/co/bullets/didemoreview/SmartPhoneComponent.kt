package kr.co.bullets.didemoreview

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MemoryCardModule::class, NCBatteryModule::class])
interface SmartPhoneComponent {

    // If we invoke a function like getSmartPhone. We will be able to only get that SmartPhone dependency.
//    fun getSmartPhone(): SmartPhone

    fun inject(mainActivity: MainActivity)
}