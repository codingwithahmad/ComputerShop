package ahmad.ir.farhngcomputershop

import ahmad.ir.farhngcomputershop.adapter.HeaderAdapter
import ahmad.ir.farhngcomputershop.constant.Utils
import ahmad.ir.farhngcomputershop.database.DatabaseClass
import ahmad.ir.farhngcomputershop.viewmodel.MainViewModel
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.btm_view);
        val navigation = findNavController(R.id.fragment_nav);

        bottomNavigation.setupWithNavController(navigation);



    }
}