package kr.co.bullets.didemo

import android.util.Log

class SIMCard(private val serviceProvider: ServiceProvider) {
//class SIMCard() {

//    private lateinit var serviceProvider: ServiceProvider
//    public lateinit var serviceProvider: ServiceProvider

    init {
        Log.i("MYTAG", "SIM Card Constructed")
    }

//    fun setServiceProvider(serviceProvider: ServiceProvider) {
//        this.serviceProvider = serviceProvider
//    }

    fun getConnection() {
        serviceProvider.getServiceProvider()
    }
}