package ahmad.ir.farhngcomputershop.repository

import ahmad.ir.farhngcomputershop.database.ImageDao
import ahmad.ir.farhngcomputershop.models.Header
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class Repository @Inject constructor(
    val imageDao: ImageDao
) {

    suspend fun insertHeader(header: Header) {
        imageDao.insert(header)
    }

     fun getAllHeaders():List<Header> = imageDao.getAllImage()


}