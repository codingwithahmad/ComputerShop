package ahmad.ir.farhngcomputershop

import ahmad.ir.farhngcomputershop.adapter.HeaderAdapter
import ahmad.ir.farhngcomputershop.database.ImageDao
import ahmad.ir.farhngcomputershop.viewmodel.MainViewModel
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
        lifecycleScope.launch(Dispatchers.IO) {
            adapter.submitList(mainViewModel.getAllData())
            lifecycleScope.launch(Dispatchers.Main) {
                view.rec_view_header.adapter = adapter
            }
        }



        return view
    }


}