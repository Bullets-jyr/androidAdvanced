package kr.co.bullets.viewmodeldemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kr.co.bullets.viewmodeldemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
//    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        // 현재 액티비티를 수명주기 소유자로 지정하여 LiveData의 수명주기를 액티비티의 수명주기와 동일하게 만들어줍니다.
        // 이렇게 하면 액티비티가 파괴될 때 Observer도 함께 파괴되므로 메모리 누수와 앱 성능 문제가 해결됩니다.
        // 또한, 액티비티가 재생성되더라도 새로운 Observer가 등록되어 LiveData를 관찰할 수 있습니다.
        binding.lifecycleOwner = this

        binding.myViewModel = viewModel

//        binding.countText.text = count.toString()
//        binding.countText.text = viewModel.getCurrentCount().toString()

//        viewModel.count.observe(this, Observer {
//            binding.countText.text = it.toString()
//        })

//        binding.button.setOnClickListener {
//            count++
//            binding.countText.text = viewModel.getUpdatedCount().toString()
//            viewModel.updateCount()
//        }
    }
}