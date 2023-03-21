package mdmccullough.wccnet.edu.navigationproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import mdmccullough.wccnet.edu.navigationproject.R
import mdmccullough.wccnet.edu.navigationproject.databinding.FragmentMainBinding

class MainFragment : Fragment() {


    private lateinit var viewModel: MainViewModel

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button1.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond =
                MainFragmentDirections.mainToSecond("Image 1", R.drawable.android_image_1)

            Navigation.findNavController(it).navigate(action)
        }
        binding.button2.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond =
                MainFragmentDirections.mainToSecond("Image 2", R.drawable.android_image_2)

            Navigation.findNavController(it).navigate(action)
        }
        binding.button3.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond =
                MainFragmentDirections.mainToSecond("Image 3", R.drawable.android_image_3)

            Navigation.findNavController(it).navigate(action)
        }
        binding.imageView1.setImageResource(R.drawable.android_image_1)
        binding.imageView2.setImageResource(R.drawable.android_image_2)
        binding.imageView3.setImageResource(R.drawable.android_image_3)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}