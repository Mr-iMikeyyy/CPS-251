package mdmccullough.wccnet.edu.lifecycleaware.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var logText: MutableLiveData<String> = MutableLiveData("")
}