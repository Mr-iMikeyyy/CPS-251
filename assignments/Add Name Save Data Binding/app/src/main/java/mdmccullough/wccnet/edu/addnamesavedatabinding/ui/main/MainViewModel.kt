package mdmccullough.wccnet.edu.addnamesavedatabinding.ui.main

import android.app.AlertDialog
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mdmccullough.wccnet.edu.addnamesavedatabinding.R

class MainViewModel : ViewModel() {
    var displayNames: MutableLiveData<String> = MutableLiveData("")
    var nameToEnter: MutableLiveData<String?> = MutableLiveData("")
    var isNameEmpty: MutableLiveData<Boolean> = MutableLiveData(false)
    fun setDisplayText() {
        nameToEnter.let {
            if (!nameToEnter.value.isNullOrEmpty()) {
                displayNames.value += it.value + "\n"
            } else {
                isNameEmpty.value=true
            }
        }
    }
}