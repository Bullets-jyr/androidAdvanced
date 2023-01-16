package kr.co.bullets.roommigrationdemo1

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDAO {

    @Insert
    suspend fun insertStudent(student: Student)

}