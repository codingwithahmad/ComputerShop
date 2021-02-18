package ahmad.ir.farhngcomputershop.repository

import ahmad.ir.farhngcomputershop.api.MyApi
import ahmad.ir.farhngcomputershop.database.ImageDao
import ahmad.ir.farhngcomputershop.models.Header
import ahmad.ir.farhngcomputershop.models.Laptop
import ahmad.ir.farhngcomputershop.retrofit.RetrofitInstance
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject


class Repository @Inject constructor(
    val imageDao: ImageDao,
) {


    fun getLaptop(): Call<MutableList<Laptop?>?>? {
        return RetrofitInstance.api.getData()
    }


    suspend fun insertHeader(header: Header) {
        imageDao.insert(header)
    }

     fun getAllHeaders():List<Header> = imageDao.getAllImage()




}