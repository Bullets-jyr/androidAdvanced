package kr.co.bullets.viewmodeldemo2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel() {

//    private var total = 0
    private var total = MutableLiveData<Int>()
    val totalData: LiveData<Int>
    get() = total

    val inputText = MutableLiveData<String>()

    init {
//        total = startingTotal
        total.value = startingTotal
    }

//    fun getTotal(): Int {
//        return total
//    }

//    fun setTotal(input: Int) {
//        total += input
//        total.value = (total.value)?.plus(input)
//    }

    fun setTotal() {
//        total += input
        val intInput: Int = inputText.value!!.toInt()
        total.value = (total.value)?.plus(intInput)
    }
}