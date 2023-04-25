package mdmccullough.wccnet.edu.contacts

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactRepository(application: Application) {

    val searchResults = MutableLiveData<List<Contact>>()
    private var contactDao: ContactDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allContacts: LiveData<List<Contact>>?

    init {
        val db: ContactRoomDatabase? =  ContactRoomDatabase.getDatabase(application)
        contactDao = db?.contactDao()
        allContacts = contactDao?.getAllContacts()
    }

    fun insertContact(newContact: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newContact)
        }
    }

    private fun asyncInsert(contact: Contact) {
        contactDao?.insertContact(contact)
    }

    fun deleteContact(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(id)
        }
    }

    private fun asyncDelete(id: Int) {
        contactDao?.deleteContact(id)
    }

    fun findContact(name: String) {

        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name)
        }
    }

    private suspend fun asyncFind(name: String): List<Contact>? =

        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.findContact(name)
        }.await()

}