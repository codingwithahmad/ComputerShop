package ahmad.ir.farhngcomputershop.di


import ahmad.ir.farhngcomputershop.api.MyApi
import ahmad.ir.farhngcomputershop.constant.Utils.DATABASE_NAME
import ahmad.ir.farhngcomputershop.database.DatabaseClass
import ahmad.ir.farhngcomputershop.database.ImageDao
import ahmad.ir.farhngcomputershop.models.Laptop
import ahmad.ir.farhngcomputershop.other.Utils
import ahmad.ir.farhngcomputershop.repository.Repository
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.internal.Util
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context:Context
    ) = Room.databaseBuilder(context,DatabaseClass::class.java,DATABASE_NAME)
            .allowMainThreadQueries()
            .build()

    @Singleton
    @Provides
    fun provideDao(
        databaseClass: DatabaseClass
    ) = databaseClass.imageDao()


    @Singleton
    @Provides
    fun provideRepository(imageDao: ImageDao) = Repository(imageDao);






}