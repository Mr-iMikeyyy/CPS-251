package mdmccullough.wccnet.edu.addnamesavedatabinding.ui.main

import android.app.AlertDialog
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import mdmccullough.wccnet.edu.addnamesavedatabinding.R
import mdmccullough.wccnet.edu.addnamesavedatabinding.databinding.FragmentMainBinding
import mdmccullough.wccnet.edu.addnamesavedatabinding.BR.myViewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.setVariable(myViewModel, viewModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.isNameEmpty.observe(viewLifecycleOwner) { isEmpty ->
            if (isEmpty) {
                showEmptyNameAlert()
                viewModel.isNameEmpty.value = false
            }
        }
    }
    private fun showEmptyNameAlert() {
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setTitle(R.string.error_title)
        alertDialogBuilder.setMessage(R.string.error_message)
        alertDialogBuilder.setPositiveButton(R.string.ok) { _, _ -> }
        alertDialogBuilder.create().show()
    }
}