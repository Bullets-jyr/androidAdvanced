package kr.co.bullets.livedatademo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import kr.co.bullets.livedatademo.model.UserRepository

class MainActivityViewModel : ViewModel()  {

    private var usersRepository = UserRepository()

    var users = liveData(Dispatchers.IO) {
        val result = usersRepository.getUsers()
        emit(result)
    }

//    var users: MutableLiveData<List<User>> = MutableLiveData()
//
//    fun getUsers() {
//        viewModelScope.launch {
//            var result: List<User>? = null
//            withContext(Dispatchers.IO) {
//                result = usersRepository.getUsers()
//            }
//            users.value = result
//        }
//    }
}