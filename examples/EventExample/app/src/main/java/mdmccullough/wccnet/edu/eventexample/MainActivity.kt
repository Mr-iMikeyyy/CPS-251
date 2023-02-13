package mdmccullough.wccnet.edu.eventexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mdmccullough.wccnet.edu.eventexample.databinding.ActivityMainBinding
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myButton.setOnClickListener {
            binding.statusText.text = "Button clicked"
        }
    }
}