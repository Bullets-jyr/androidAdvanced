package kr.co.bullets.didemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

//    private lateinit var smartPhone: SmartPhone
    @Inject
    lateinit var smartPhone: SmartPhone

//    @Inject
//    lateinit var memoryCard: MemoryCard

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