package ahmad.ir.farhngcomputershop.di


import ahmad.ir.farhngcomputershop.constant.Utils.DATABASE_NAME
import ahmad.ir.farhngcomputershop.database.DatabaseClass
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context:Context
    ) = Room.databaseBuilder(context,DatabaseClass::class.java,DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDao(
        databaseClass: DatabaseClass
    ) = databaseClass.imageDao()


}