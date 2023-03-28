package kr.co.bullets.didemoreview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val battery = Battery()
//        val memoryCard = MemoryCard()
//        val serviceProvider = ServiceProvider()
//        val simCard = SIMCard(serviceProvider)
        // This type of dependency injection is called Constructor injection.
//        val smartPhone = SmartPhone(battery, simCard, memoryCard)
//        smartPhone.makeACallWithRecording()
        val smartPhone = SmartPhone(
            Battery(),
            SIMCard(ServiceProvider()),
            MemoryCard()
        )
            .makeACallWithRecording()

    }
}