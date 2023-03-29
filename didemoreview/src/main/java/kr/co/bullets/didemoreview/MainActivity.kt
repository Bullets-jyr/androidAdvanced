package kr.co.bullets.didemoreview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var smartPhone: SmartPhone

    @Inject
    lateinit var memoryCard: MemoryCard

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerSmartPhoneComponent.create()
//            .getSmartPhone()
            .inject(this)
//            .makeACallWithRecording()

        smartPhone.makeACallWithRecording()

//        val battery = Battery()
//        val memoryCard = MemoryCard()
//        val serviceProvider = ServiceProvider()
//        val simCard = SIMCard(serviceProvider)
        // This type of dependency injection is called Constructor injection.
//        val smartPhone = SmartPhone(battery, simCard, memoryCard)
//        smartPhone.makeACallWithRecording()
//        val smartPhone = SmartPhone(
//            Battery(),
//            SIMCard(ServiceProvider()),
//            MemoryCard()
//        )
//            .makeACallWithRecording()
    }
}