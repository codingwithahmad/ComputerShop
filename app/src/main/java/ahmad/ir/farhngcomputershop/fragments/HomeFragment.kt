package ahmad.ir.farhngcomputershop.fragments

import ahmad.ir.farhngcomputershop.R
import ahmad.ir.farhngcomputershop.adapter.HeaderAdapter
import ahmad.ir.farhngcomputershop.adapter.LaptopAdapter
import ahmad.ir.farhngcomputershop.api.MyApi
import ahmad.ir.farhngcomputershop.models.Header
import ahmad.ir.farhngcomputershop.models.Laptop
import ahmad.ir.farhngcomputershop.retrofit.RetrofitInstance
import ahmad.ir.farhngcomputershop.viewmodel.MainViewModel
import android.graphics.BitmapFactory
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import retrofit2.*
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {


    val mainViewModel:MainViewModel by viewModels();


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        val typeface = Typeface.createFromAsset(requireActivity().assets,"fonts/irani_nas_font.TTF")
        view.title_text.setTypeface(typeface)




        view.rec_view_header.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)
        val adapter = HeaderAdapter()

        lifecycleScope.launch() {
            adapter.submitList(mainViewModel.getAllData())
            view.rec_view_header.adapter = adapter
        }
        view.rec_laptop.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        val adapter2 = LaptopAdapter(requireContext())

        mainViewModel.getLaptop()?.enqueue(object : Callback<MutableList<Laptop?>?> {
            override fun onFailure(call: Call<MutableList<Laptop?>?>, t: Throwable) {
                Log.d("ON_E", t.message.toString())
            }

            override fun onResponse(call: Call<MutableList<Laptop?>?>, response: Response<MutableList<Laptop?>?>) {

                adapter2.submitlist(response.body())
                rec_laptop.adapter = adapter2

            }
        })

        return view
    }






}