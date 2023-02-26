package mdmccullough.wccnet.edu.addnamesavedatabinding.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var displayNames: MutableLiveData<String> = MutableLiveData("")
    var nameToEnter: MutableLiveData<String?> = MutableLiveData("")
    fun setDisplayText() {
        nameToEnter.let {
            if (!nameToEnter.value.isNullOrEmpty()) {
                displayNames.value += it.value + "\n"
            }
        }
    }
}