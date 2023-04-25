package mdmccullough.wccnet.edu.contacts.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import mdmccullough.wccnet.edu.contacts.Contact
import mdmccullough.wccnet.edu.contacts.ContactRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ContactRepository = ContactRepository(application)
    private val allContacts: LiveData<List<Contact>>? = repository.allContacts
    private val searchResults: MutableLiveData<List<Contact>> = repository.searchResults


    fun insertContact(contact: Contact) {
        repository.insertContact(contact)
    }
    fun findContact(name: String) {
        repository.findContact(name)
    }
    fun deleteContact(id: Int) {
        repository.deleteContact(id)
    }
    fun getSearchResults(): MutableLiveData<List<Contact>> {
        return searchResults
    }
    fun getAllContacts(): LiveData<List<Contact>>? {
        return allContacts
    }
    fun getAllContactsAsc(): LiveData<List<Contact>>? {
        val sortedAsc = allContacts?.value?.sortedBy { it.contactName }
        return sortedAsc?.let { MutableLiveData(it) }
    }
    fun getAllContactsDesc(): LiveData<List<Contact>>? {
        val sortedDesc = allContacts?.value?.sortedByDescending { it.contactName }
        return sortedDesc?.let { MutableLiveData(it) }
    }
}