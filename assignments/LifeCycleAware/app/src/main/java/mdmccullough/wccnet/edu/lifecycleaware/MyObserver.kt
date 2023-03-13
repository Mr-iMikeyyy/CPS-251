package mdmccullough.wccnet.edu.lifecycleaware

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import mdmccullough.wccnet.edu.lifecycleaware.ui.main.MainViewModel
import java.time.LocalTime

class MyObserver(private var viewModel: MainViewModel) : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        viewModel.logText.value += "onResume was fired on " + LocalTime.now().toString() + "\n" + "******************" + "\n"
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        viewModel.logText.value += "onPause was fired on " + LocalTime.now().toString() + "\n" + "******************" + "\n"
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        viewModel.logText.value += "onCreate was fired on " + LocalTime.now().toString() + "\n"
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        viewModel.logText.value += "onStart was fired on " + LocalTime.now().toString() + "\n"
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        viewModel.logText.value += "onStop was fired on " + LocalTime.now().toString() + "\n"
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        viewModel.logText.value += "onDestroy was fired on " + LocalTime.now().toString() + "\n" + "******************" + "\n"
    }
}