package ahmad.ir.farhngcomputershop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.os.HandlerCompat.postDelayed
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val f_anim:Animation = AnimationUtils.loadAnimation(this,R.anim.fadein_anim)
        name_txt.startAnimation(f_anim)
        img_logo.startAnimation(f_anim)

        Glide.with(this).asGif()
            .load("https://d33wubrfki0l68.cloudfront.net/7ad98dc27fb7d45a2570730eda827673d6028969/c1127/images/loading.gif")
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(load_gif)

        Handler().postDelayed(Runnable {
            kotlin.run {
                val intent = Intent(this,HomeActivity::class.java)
                startActivity(intent)
            }
        },5000L)

    }

}