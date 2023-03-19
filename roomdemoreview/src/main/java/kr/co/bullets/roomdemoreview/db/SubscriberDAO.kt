package kr.co.bullets.roomdemoreview.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDAO {

//    @Insert(onConflict = OnConflictStrategy.IGNORE)
    // OnConflictStrategy.REPLACE: 충돌이 발생하면 기존 데이터를 삭제하고 새로운 데이터로 대체합니다.
    // OnConflictStrategy.IGNORE: 충돌이 발생하면 무시하고 삽입을 시도하지 않습니다.
    // OnConflictStrategy.ABORT: 충돌이 발생하면 삽입을 중단하고 예외를 발생시킵니다.
    // OnConflictStrategy.ROLLBACK: 충돌이 발생하면 삽입 전에 모든 변경사항을 롤백하고 예외를 발생시킵니다.
    // OnConflictStrategy.FAIL: 충돌이 발생하면 예외를 발생시킵니다.
    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber): Long

//    @Insert
//    fun insertSubscriber2(subscriber: Subscriber): Long

//    @Insert
//    fun insertSubscribers(subscriber1: Subscriber, subscriber2: Subscriber, subscriber3: Subscriber): List<Long>

//    @Insert
//    fun insertSubscribers(subscribers: List<Subscriber>): List<Long>

//    @Insert
//    fun insertSubscriber2(subscriber: Subscriber, subscribers: List<Subscriber>): List<Long>

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber): Int

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber): Int

    @Query("DELETE FROM subscriber_data_table")
    suspend fun deleteAll(): Int

    @Query("SELECT * FROM subscriber_data_table")
    fun getAllSubscribers(): LiveData<List<Subscriber>>

//    @Query("SELECT * FROM subscriber_data_table")
//    fun getAllSubscribers(): Flow<List<Subscriber>>
}