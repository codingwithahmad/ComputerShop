package ahmad.ir.farhngcomputershop.api

import ahmad.ir.farhngcomputershop.models.Laptop
import retrofit2.Call
import retrofit2.http.GET

interface MyApi {

    @GET("laptop")
    fun getData(): Call<MutableList<Laptop?>?>?

}