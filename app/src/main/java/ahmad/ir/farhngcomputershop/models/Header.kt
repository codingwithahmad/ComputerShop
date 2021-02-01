package ahmad.ir.farhngcomputershop.models

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "header")
data class Header(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val image:Bitmap? = null
) {

}