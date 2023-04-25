package mdmccullough.wccnet.edu.contacts.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import mdmccullough.wccnet.edu.contacts.Contact
import mdmccullough.wccnet.edu.contacts.R
import mdmccullough.wccnet.edu.contacts.databinding.FragmentMainBinding

@Suppress("DEPRECATION")
class MainFragment : Fragment() {

    private var adapter: ContactListAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        listenerSetup()
        observerSetup()
        recyclerSetup()
    }

    private fun clearFields() {
        binding.enterContactName.setText("")
        binding.enterContactNumber.setText("")
    }

    private fun listenerSetup() {
        binding.addButton.setOnClickListener {
            val contactName = binding.enterContactName.text.toString()
            val contactNumber = binding.enterContactNumber.text.toString()

            if (contactName != "" && contactNumber != "") {
                val contact = Contact(contactName, contactNumber)
                viewModel.insertContact(contact)
                clearFields()
            } else {
                Toast.makeText(context, "You must enter a name and phone number", Toast.LENGTH_SHORT).show()
            }
        }

        binding.findButton.setOnClickListener {

            val contactName = binding.enterContactName.text.toString()

            if (contactName != "") {
                viewModel.findContact(contactName)
            } else {
                Toast.makeText(context, "You must enter search criteria in the name field", Toast.LENGTH_SHORT).show()
            }

        }

        binding.ascButton.setOnClickListener {
            adapter?.setContactList(viewModel.getAllContactsAsc()?.value!!)
        }
        binding.descButton.setOnClickListener {
            adapter?.setContactList(viewModel.getAllContactsDesc()?.value!!)
        }
    }

    private fun observerSetup() {
        viewModel.getAllContacts()?.observe(viewLifecycleOwner) { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }

        }

        viewModel.getSearchResults().observe(viewLifecycleOwner) { products ->
            products?.let {
                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
                } else {
                    Toast.makeText(context, "There are no contacts that match your search", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.card_layout, viewModel)
        binding.contactRecycler.layoutManager = LinearLayoutManager(context)
        binding.contactRecycler.adapter = adapter
    }
}