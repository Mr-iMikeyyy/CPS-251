package mdmccullough.wccnet.edu.lifecycleaware.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import mdmccullough.wccnet.edu.lifecycleaware.R
import mdmccullough.wccnet.edu.lifecycleaware.databinding.FragmentMainBinding
import mdmccullough.wccnet.edu.lifecycleaware.BR.myViewModel
import mdmccullough.wccnet.edu.lifecycleaware.MyObserver

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]



        lifecycle.addObserver(MyObserver(viewModel))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.lifecycleOwner = this
        binding.setVariable(myViewModel, viewModel)
        return binding.root
    }

}