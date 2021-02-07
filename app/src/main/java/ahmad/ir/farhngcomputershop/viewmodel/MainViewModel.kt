package ahmad.ir.farhngcomputershop.viewmodel

import ahmad.ir.farhngcomputershop.api.MyApi
import ahmad.ir.farhngcomputershop.database.ImageDao
import ahmad.ir.farhngcomputershop.models.Header
import ahmad.ir.farhngcomputershop.models.Laptop
import ahmad.ir.farhngcomputershop.repository.Repository
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel @ViewModelInject constructor(
     val imageDao: ImageDao,

) : ViewModel() {
    val repository = Repository(imageDao)



    fun getLaptop() = repository.getLaptop()

    fun insertHeader(header: Header) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertHeader(header)
        }
    }

     fun getAllData():List<Header> = repository.getAllHeaders()


}