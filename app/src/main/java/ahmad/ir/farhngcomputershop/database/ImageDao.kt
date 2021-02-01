package ahmad.ir.farhngcomputershop.database

import ahmad.ir.farhngcomputershop.models.Header
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(header: Header)

    @Query("select * from header")
    fun getAllImage():List<Header>



}