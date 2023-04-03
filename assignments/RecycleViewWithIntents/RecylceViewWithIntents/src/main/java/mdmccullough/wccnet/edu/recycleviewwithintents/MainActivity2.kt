package mdmccullough.wccnet.edu.recycleviewwithintents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mdmccullough.wccnet.edu.recycleviewwithintents.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val dispTitle = intent.getStringExtra("dispTitle")
        val dispDetail = intent.getStringExtra("dispDetail")
        val dispImage = intent.getIntExtra("dispImage", 0)

        binding.displayTitle.text = dispTitle
        binding.displayDetail.text = dispDetail
        binding.displayImage.setImageResource(dispImage)
    }
}