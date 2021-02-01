package ahmad.ir.farhngcomputershop.constant

import ahmad.ir.farhngcomputershop.R
import ahmad.ir.farhngcomputershop.database.DatabaseClass
import ahmad.ir.farhngcomputershop.database.ImageDao
import ahmad.ir.farhngcomputershop.models.Header
import android.content.Context
import android.content.res.Resources
import android.content.res.loader.ResourcesProvider
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


object Utils {
        const val DATABASE_NAME = "myDatabase"
}