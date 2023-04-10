package mdmccullough.wccnet.edu.coroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val nameList: MutableList<String> = mutableListOf()
    val delayList: MutableList<Long> = mutableListOf()

}