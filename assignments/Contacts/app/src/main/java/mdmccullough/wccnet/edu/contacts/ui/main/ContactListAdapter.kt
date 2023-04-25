package mdmccullough.wccnet.edu.contacts.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mdmccullough.wccnet.edu.contacts.Contact
import mdmccullough.wccnet.edu.contacts.R

class ContactListAdapter(private val contactItemLayout: Int, private val viewModel: MainViewModel) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {
    private var contactList: List<Contact>? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var contactName: TextView = itemView.findViewById(R.id.contactName)
        var contactNumber: TextView = itemView.findViewById(R.id.contactNumber)
        var trashCan: ImageView = itemView.findViewById(R.id.trashCan)
    }

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val contactName = holder.contactName
        val contactNumber = holder.contactNumber
        val id: Int
        contactList.let {
            contactName.text = it!![listPosition].contactName
            contactNumber.text = it[listPosition].contactNumber
            id = it[listPosition].id
        }
        val trashCan = holder.trashCan
        trashCan.setImageResource(R.drawable.trashcan)
        trashCan.setOnClickListener {
            viewModel.deleteContact(id)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            contactItemLayout, parent, false
        )
        return ViewHolder(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }


}