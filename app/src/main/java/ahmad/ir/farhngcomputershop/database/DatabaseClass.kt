package ahmad.ir.farhngcomputershop.database

import ahmad.ir.farhngcomputershop.constant.Constant
import ahmad.ir.farhngcomputershop.models.Header
import android.content.Context
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = arrayOf(Header::class),version = 1,exportSchema = false)
@TypeConverters(Constant::class)
abstract class DatabaseClass: RoomDatabase() {

    abstract fun imageDao():ImageDao

}

