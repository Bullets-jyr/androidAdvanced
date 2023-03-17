package kr.co.bullets.viewmodeldemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kr.co.bullets.viewmodeldemo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainActivityViewModelFactory(125)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)
        binding.myViewModel = viewModel
        // LiveData를 직접 사용하려면 데이터 바인딩 개체를 사용하여 수명 주기 소유자를 제공해야 합니다.
        binding.lifecycleOwner = this

//        viewModel.total.observe(this, Observer {
//        viewModel.totalData.observe(this, Observer {
//            binding.resultTextView.text = it.toString()
//        })

//        binding.resultTextView.text = viewModel.getTotal().toString()

//        binding.insertButton.setOnClickListener {
//            viewModel.setTotal(binding.inputEditText.text.toString().toInt())
//            binding.resultTextView.text = viewModel.getTotal().toString()
//        }
    }
}