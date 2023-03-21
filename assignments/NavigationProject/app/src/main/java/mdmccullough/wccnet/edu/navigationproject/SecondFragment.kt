package mdmccullough.wccnet.edu.navigationproject

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import mdmccullough.wccnet.edu.navigationproject.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }


    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        arguments?.let {
            val args = SecondFragmentArgs.fromBundle(it)
            binding.argText.text = args.title
            binding.myImageView.setImageResource(args.image)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}