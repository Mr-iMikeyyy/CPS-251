package mdmccullough.wccnet.edu.addnamesavedataviewmodel.ui.main

import android.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mdmccullough.wccnet.edu.addnamesavedataviewmodel.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.displayNames.text = viewModel.getResult()

        binding.addName.setOnClickListener {
            if (binding.editTextName.text.isNotEmpty()) {
                viewModel.setDisplayText(binding.editTextName.text.toString())
                binding.displayNames.text = viewModel.getResult()
            }else {
                val builder = AlertDialog.Builder(this.context)

                builder.setTitle("No Name Entered")
                builder.setMessage("Please enter a name in the enter name area")
                val alert = builder.create()
                alert.show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}