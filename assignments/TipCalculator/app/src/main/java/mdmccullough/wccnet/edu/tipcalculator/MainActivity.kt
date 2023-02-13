package mdmccullough.wccnet.edu.tipcalculator

//import android.util.Log
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import mdmccullough.wccnet.edu.tipcalculator.databinding.ActivityMainBinding

//import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

//    val TAG : String = "Debug"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcButton.setOnClickListener {

            if (TextUtils.isEmpty(binding.numText.text.toString())) {
//                Log.d(TAG,"button clicked")
                binding.output.text = resources.getString(R.string.you_must_enter_a_bill_amount)
//                binding.output.text = "YOU MUST ENTER A BILL AMOUNT"
            }
            else {
                val bill : Double = binding.numText.text.toString().toDouble()
                val tip10 : String = String.format("%.2f",(bill * .1 ) + bill)
                val tip15 : String = String.format("%.2f",(bill * .15 ) + bill)
                val tip20 : String = String.format("%.2f",(bill * .20 ) + bill)
                binding.output.text = resources.getString(R.string.output, tip10,tip15, tip20)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // Save the state
        outState.putString("out_string", binding.output.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        // Read the state
        binding.output.text = savedInstanceState.getString("out_string")
    }
}