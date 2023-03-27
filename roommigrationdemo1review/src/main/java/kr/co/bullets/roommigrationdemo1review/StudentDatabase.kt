package kr.co.bullets.roommigrationdemo1review

import android.content.Context
import androidx.room.*
import androidx.room.migration.AutoMigrationSpec

// default : exportSchema = true
@Database(
    entities = [Student::class],
    version = 5,
    exportSchema = true,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3),
        AutoMigration(from = 3, to = 4, spec = StudentDatabase.Migration3To4::class),
        AutoMigration(from = 4, to = 5, spec = StudentDatabase.Migration4To5::class),
    ]
)
abstract class StudentDatabase : RoomDatabase() {

    abstract val subscriberDAO : StudentDAO

    @RenameColumn(tableName = "student_info", fromColumnName = "course_name", toColumnName = "subject_name")
    class Migration3To4 : AutoMigrationSpec

    @DeleteColumn(tableName = "student_info", columnName = "student_email")
    class Migration4To5 : AutoMigrationSpec

    companion object{
      @Volatile
      private var INSTANCE : StudentDatabase? = null
          fun getInstance(context: Context):StudentDatabase{
              synchronized(this){
                  var instance = INSTANCE
                      if(instance == null) {
                          instance = Room.databaseBuilder(
                                 context.applicationContext,
                              StudentDatabase::class.java,
                                 "student_data_database"
                          ).build()
                          INSTANCE = instance
                      }
                  return instance
              }
          }
    }
}

