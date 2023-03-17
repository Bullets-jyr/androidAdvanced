package kr.co.bullets.twowaydemo1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    val userName = MutableLiveData<String>()

    init {
        userName.value = "류지영"
    }
}