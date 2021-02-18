 package ahmad.ir.farhngcomputershop.retrofit

import ahmad.ir.farhngcomputershop.api.MyApi
import ahmad.ir.farhngcomputershop.other.Utils.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }


    val api:MyApi by lazy {
        retrofit.create(MyApi::class.java)
    }
}