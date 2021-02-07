package ahmad.ir.farhngcomputershop.api

import ahmad.ir.farhngcomputershop.models.Laptop
import retrofit2.http.GET

interface MyApi {

    @GET("laptop")
    fun getPost() : List<Laptop>

}