package mdmccullough.wccnet.edu.recycleview

import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel : ViewModel() {
    private val myData = Data()

    val titles: Array<String> = myData.titles.randomizeArray()
    val details: Array<String> = myData.details.randomizeArray()
    val images: IntArray = myData.images.randomizeIntArray()

    private fun <T> Array<T>.randomizeArray(): Array<T> {
        val random = Random()
        for (i in size - 1 downTo 1) {
            val j = random.nextInt(i + 1)
            val temp = this[i]
            this[i] = this[j]
            this[j] = temp
        }
        return this
    }
    private fun IntArray.randomizeIntArray(): IntArray {
        val random = Random()
        for (i in size - 1 downTo 1) {
            val j = random.nextInt(i + 1)
            val temp = this[i]
            this[i] = this[j]
            this[j] = temp
        }
        return this
    }
}