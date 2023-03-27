package kr.co.bullets.roomdemoreview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kr.co.bullets.roomdemoreview.db.Subscriber
import kr.co.bullets.roomdemoreview.db.SubscriberRepository

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel() {

    // LiveData
    val subscribers = repository.subscribers
    private var isUpdateOrDelete = false
    private lateinit var subscriberToUpdateOrDelete: Subscriber

    val inputName = MutableLiveData<String>()
    val inputEmail = MutableLiveData<String>()

    val saveOrUpdateButtonText = MutableLiveData<String>()
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()

    val message: LiveData<Event<String>>
        get() = statusMessage

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun saveOrUpdate() {
        if (isUpdateOrDelete) {
            subscriberToUpdateOrDelete.name = inputName.value!!
            subscriberToUpdateOrDelete.email = inputEmail.value!!
            update(subscriberToUpdateOrDelete)
        } else {
            val name = inputName.value!!
            val email = inputEmail.value!!
            insert(Subscriber(0, name, email))
            inputName.value = ""
            inputEmail.value = ""
        }
    }

    fun clearAllOrDelete() {
        if (isUpdateOrDelete) {
            delete(subscriberToUpdateOrDelete)
        } else {
            clearAll()
        }
    }

    fun insert(subscriber: Subscriber) {
        // viewModelScope는 ViewModel에서 코루틴을 사용할 때 사용하는 CoroutineScope입니다.
        // viewModelScope를 사용하면 ViewModel 생명주기에 따라서 코루틴을 실행하고,
        // ViewModel이 소멸될 때 코루틴도 함께 취소됩니다. 이는 앱에서 비동기 처리를 할 때 매우 유용합니다.
        // 예를 들어, ViewModel에서 데이터를 가져오는 API 호출을 코루틴으로 처리한다면,
        // 액티비티가 백그라운드로 이동하여 화면이 회전되는 등의 상황에서도 코루틴이 취소되어 메모리 누수나 오작동 등의 문제를 예방할 수 있습니다.
        // 따라서, viewModelScope를 사용하면 ViewModel에서 비동기 처리를 할 때 안정적이고 쉽게 구현할 수 있으며, 안드로이드 앱의 성능과 안정성을 향상시킬 수 있습니다.
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(subscriber)
            withContext(Dispatchers.Main) {
                statusMessage.value = Event("Subscriber Inserted Successfully!")
            }
        }
    }

//    fun insert(subscriber: Subscriber) = viewModelScope.launch(Dispatchers.IO) {
//        repository.insert(subscriber)
//    }

    fun update(subscriber: Subscriber) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(subscriber)
        withContext(Dispatchers.Main) {
            inputName.value = ""
            inputEmail.value = ""
            isUpdateOrDelete = false
            saveOrUpdateButtonText.value = "Save"
            clearAllOrDeleteButtonText.value = "Clear All"
            statusMessage.value = Event("Subscriber Updated Successfully!")
        }
    }

    fun delete(subscriber: Subscriber) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(subscriber)
        // Since we are going to directly deal with the UI, we need to change the thread using withContext()
        withContext(Dispatchers.Main) {
            inputName.value = ""
            inputEmail.value = ""
            isUpdateOrDelete = false
            saveOrUpdateButtonText.value = "Save"
            clearAllOrDeleteButtonText.value = "Clear All"
            statusMessage.value = Event("Subscriber Deleted Successfully!")
        }
    }

    fun clearAll() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAll()
        withContext(Dispatchers.Main) {
            statusMessage.value = Event("All Subs Successfully!")
        }
    }

    fun initUpdateAndDelete(subscriber: Subscriber) {
        inputName.value = subscriber.name
        inputEmail.value = subscriber.email
        isUpdateOrDelete = true
        subscriberToUpdateOrDelete = subscriber
        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
    }
}