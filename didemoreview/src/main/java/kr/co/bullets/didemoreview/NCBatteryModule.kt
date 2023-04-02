package kr.co.bullets.didemoreview

import dagger.Binds
import dagger.Module
import dagger.Provides

// Here we have a dependency of NickelCadmiumBattery.
// As it has implemented Battery interface we know this is a Battery.
// But dagger does not know that yet. Dagger does not type cast for dependencies in that way.
// We have to create a module and provide this NickelCadmiumBattery dependency as a Battery dependency.

// Actually we can make this code even more concise.
// In our app, we have already annotated the constructor of the NickelCadmiumBattery class with inject annotatin.
// Therefore we don’t need a body for this provides function.
// So we can just define this module as an abstract module.
// then make this function as abstract. And remove the function body.
@Module
abstract class NCBatteryModule {
//class NCBatteryModule {

    // As we have already annotated the constructor of the NickelCadmiumBattery with @Inject annotation,
    // dagger can construct that dependency.
    // So we can just use that dependency here, we don’t have to construct it again.
    // Dagger recognizes this returned dependency by considering the return type of the provider function.
    // So dagger will recognize this dependency as a battery.
//    @Provides
//    fun provideNCBattery(nickelCadmiumBattery: NickelCadmiumBattery): Battery {
//        return nickelCadmiumBattery
//    }

    // In dagger abstract functions cannot be annotated with @Provides annotation.
    // But dagger has provided an option to annotate them with @Binds annotation.
    @Binds
    abstract fun bindsNCBattery(nickelCadmiumBattery: NickelCadmiumBattery): Battery
}