package ahmad.ir.farhngcomputershop.fragments

import ahmad.ir.farhngcomputershop.R
import ahmad.ir.farhngcomputershop.adapter.HeaderAdapter
import ahmad.ir.farhngcomputershop.models.Header
import ahmad.ir.farhngcomputershop.viewmodel.MainViewModel
import android.graphics.BitmapFactory
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.coroutines.launch

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

        return view
    }


}