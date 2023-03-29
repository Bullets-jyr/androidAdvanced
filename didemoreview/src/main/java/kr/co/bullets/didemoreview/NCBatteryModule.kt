package kr.co.bullets.didemoreview

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class NCBatteryModule {
//class NCBatteryModule {

//    @Provides
//    fun provideNCBattery(nickelCadmiumBattery: NickelCadmiumBattery): Battery {
//        return nickelCadmiumBattery
//    }

    @Binds
    abstract fun bindsNCBattery(nickelCadmiumBattery: NickelCadmiumBattery): Battery
}