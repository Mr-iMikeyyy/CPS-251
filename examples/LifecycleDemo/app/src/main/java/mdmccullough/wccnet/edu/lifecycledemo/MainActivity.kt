package mdmccullough.wccnet.edu.lifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mdmccullough.wccnet.edu.lifecycledemo.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}