package kr.co.bullets.viewmodeldemo2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivityViewModelFactory(private val startingTotal: Int) : ViewModelProvider.Factory {

    // ViewModel을 생성하기 위해 복잡한 로직이 필요하거나, ViewModel 생성자에 전달해야 하는 매개변수가 있거나, ViewModel의 의존성을 주입해야 하는 경우
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(startingTotal) as T
        }
        throw java.lang.IllegalArgumentException("Unknown View Model Class")
    }
}