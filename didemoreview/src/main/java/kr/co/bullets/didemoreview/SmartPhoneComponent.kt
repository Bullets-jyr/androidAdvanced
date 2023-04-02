package kr.co.bullets.didemoreview

import dagger.Component
import javax.inject.Singleton

@Singleton
// Here we need to link our module to this component.
@Component(modules = [MemoryCardModule::class, NCBatteryModule::class])
interface SmartPhoneComponent {

    // Now we can write an abstract function to get the dependency we want.
    // But the return type of the function should be the type of the dependency you want.
    // Let’s name the function as getSmartPhone. Return type should be SmartPhone.
    // When generating codes for dependency injection, dagger will only consider this return type.
    // If we invoke a function like getSmartPhone. We will be able to only get that SmartPhone dependency.
//    fun getSmartPhone(): SmartPhone

    fun inject(mainActivity: MainActivity)
}