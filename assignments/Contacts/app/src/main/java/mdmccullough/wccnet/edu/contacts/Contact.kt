package mdmccullough.wccnet.edu.contacts

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
class Contact {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contactId")
    var id: Int = 0

    @ColumnInfo(name = "contactName")
    var contactName: String? = null

    @ColumnInfo(name = "contactNumber")
    var contactNumber: String? = null

    constructor()

//    constructor(id: Int, productName: String, quantity: Int) {
//        this.productName = productName
//        this.quantity = quantity
//    }

    constructor(contactName: String, contactNumber: String) {
        this.contactName = contactName
        this.contactNumber = contactNumber
    }
}