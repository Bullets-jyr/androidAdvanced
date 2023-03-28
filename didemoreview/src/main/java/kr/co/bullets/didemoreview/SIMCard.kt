package kr.co.bullets.didemoreview

import android.util.Log

class SIMCard(private  val serviceProvider: ServiceProvider) {
//class SIMCard() {

//    private lateinit var serviceProvider: ServiceProvider
    // This kind of injection is called field injection.
//    public lateinit var serviceProvider: ServiceProvider

    init {
        Log.i("MYTAG","SIM Card Constructed")
    }

    // Dependency injection using a function is called method injection.
//    fun setServiceProvider(serviceProvider: ServiceProvider) {
//        this.serviceProvider = serviceProvider
//    }

    fun getConnection(){
        serviceProvider.getServiceProvider()
    }
}