package mdmccullough.wccnet.edu.contacts

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {

    @Insert
    fun insertContact(contact: Contact)

    @Query("SELECT * FROM contacts WHERE contactName LIKE '%' || :name || '%'")
    fun findContact(name: String): List<Contact>

    @Query("DELETE FROM contacts WHERE contactId = :id")
    fun deleteContact(id: Int)

    @Query("SELECT * FROM contacts ORDER BY contactId")
    fun getAllContacts(): LiveData<List<Contact>>

}