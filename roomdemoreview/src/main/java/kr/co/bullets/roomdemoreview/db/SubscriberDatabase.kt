package kr.co.bullets.roomdemoreview.db

import android.content.Context
import androidx.room.*
import androidx.room.migration.AutoMigrationSpec

@Database(
    entities = [Subscriber::class],
    version = 3,
    autoMigrations = [
        AutoMigration(from = 1, to = 2, spec = SubscriberDatabase.Migration1To2::class),
        AutoMigration(from = 2, to = 3, spec = SubscriberDatabase.Migration2To3::class),
    ]
)
abstract class SubscriberDatabase : RoomDatabase() {

    abstract val subscriberDAO: SubscriberDAO

    @RenameColumn(tableName = "subscriber_data_table", fromColumnName = "subscriber_id", toColumnName = "subs_id")
    class Migration1To2 : AutoMigrationSpec

    @RenameColumn(tableName = "subscriber_data_table", fromColumnName = "subscriber_name", toColumnName = "subs_name")
    class Migration2To3 : AutoMigrationSpec

    // Kotlin에서는 객체지향 디자인 패턴 중 하나인 싱글톤 패턴을 쉽게 구현하기 위해 companion object를 제공합니다.
    // companion object 키워드로 선언된 객체는 해당 클래스의 인스턴스를 생성하지 않아도 접근 가능합니다.
    companion object {

        // @Volatile을 사용하면 해당 변수가 캐시를 거치지 않고 항상 메인 메모리에서 값을 읽고 쓰기 때문에 스레드 안전성이 보장됩니다.
        // 멀티 스레드 환경에서도 안전하게 값을 읽고 쓸 수 있습니다. 즉, 하나의 스레드가 값을 변경하더라도, 다른 스레드에서는 항상 최신 값을 읽을 수 있습니다.
        // 이는 멀티스레드 환경에서 변수의 값을 안전하게 관리하기 위한 것으로, 변수의 값을 항상 메인 메모리에서 읽고 쓰도록 보장합니다.
        @Volatile
        private var INSTANCE: SubscriberDatabase? = null
        fun getInstance(context: Context): SubscriberDatabase {
            // synchronized 블록을 사용하여 메소드에 대한 동기화를 보장합니다. 이 블록 내부에서는 한 번에 하나의 스레드만이 실행됩니다.
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SubscriberDatabase::class.java,
                        "subscriber_data_database"
                    ).build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}