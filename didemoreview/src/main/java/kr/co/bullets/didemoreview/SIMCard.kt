package kr.co.bullets.didemoreview

import android.util.Log
import javax.inject.Inject

class SIMCard @Inject constructor(private  val serviceProvider: ServiceProvider) {
//class SIMCard() {

//    private lateinit var serviceProvider: ServiceProvider
    // We can also declare public fields and pass dependencies to those fields.
    // This kind of injection is called field injection.
//    public lateinit var serviceProvider: ServiceProvider

    init {
        Log.i("MYTAG","SIM Card Constructed")
    }

    // You can also pass dependencies using a function of a class.
    // Dependency injection using a function is called method injection.
//    fun setServiceProvider(serviceProvider: ServiceProvider) {
//        this.serviceProvider = serviceProvider
//    }

    fun getConnection(){
        serviceProvider.getServiceProvider()
    }
}