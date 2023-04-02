package kr.co.bullets.didemoreview

import dagger.Component
import javax.inject.Singleton

// In our current project example every time we invoke this inject function of the SmartPhoneComponent interface
// Dagger constructs a new smart phone object and inject it to the Activity.
// If we had another activity or fragment in this project which injecting the same smartphone object we would have navigated to that.
// Every time we invoke the inject function dagger constructs a new SmartPhone object in the memory.
// Not only that, in order to do so, dagger has to always construct ServiceProvider, SIMCard ,MemoryCard, and NickelCadmium battery objects as well.
// This is very inefficient. In some use cases, constructing multiple instances of the same class might cause unexpected behaviors.
// We can easily avoid this using @Singleton annotation.
// And annotate it with Singleton.
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

    // Actually, we can get injected all dependencies belong to the dependency graph.
    // Now, I am creating an abstract inject function for the MainActivity.
    // We are going use this function for the main activity. So I added an instance of main activity as a parameter.
    // If in case you need to use this component in 3 activities and one fragment, you may need to write 3 more inject functions here with those activities and fragment as parameters.
    // But what is the difference. Why we did this new change.
    // If we invoke a function like getSmartPhone. We will be able to only get that SmartPhone dependency.
    // If we wanted get another dependency we would have to create another function in the component interface and invoked it here.
    // But, now we don’t need to create a specific function for each and every dependency.
    fun inject(mainActivity: MainActivity)
}