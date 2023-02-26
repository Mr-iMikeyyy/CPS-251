package mdmccullough.wccnet.edu.addnamesavedataviewmodel.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var displayNames = ""
    fun setDisplayText(value: String) {
        this.displayNames += value + "\n"
    }
    fun getResult(): String {
        return displayNames
    }
}