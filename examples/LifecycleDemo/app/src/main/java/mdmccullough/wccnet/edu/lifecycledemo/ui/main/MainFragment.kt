package mdmccullough.wccnet.edu.lifecycledemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mdmccullough.wccnet.edu.lifecycledemo.DemoObserver
import mdmccullough.wccnet.edu.lifecycledemo.DemoOwner
import mdmccullough.wccnet.edu.lifecycledemo.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private lateinit var demoOwner: DemoOwner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        demoOwner = DemoOwner()
        demoOwner.startOwner()
        demoOwner.stopOwner()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

}