package kr.co.bullets.didemo

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class NCBatteryModule {

//    @Provides
//    fun providesNCBattery(nickelCadmiumBattery: NickelCadmiumBattery): Battery {
//        return nickelCadmiumBattery
//    }

    @Binds
    abstract fun bindsNCBattery(nickelCadmiumBattery: NickelCadmiumBattery): Battery
}