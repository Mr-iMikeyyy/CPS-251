package mdmccullough.wccnet.edu.coroutines

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val viewModel: MainViewModel) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var displayText: TextView
        init {
            displayText = itemView.findViewById(R.id.displayText)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val name = viewModel.nameList[i]
        val delay = viewModel.delayList[i]
        viewHolder.displayText.text = "The name is $name and the delay was $delay milliseconds."
    }
    override fun getItemCount(): Int {
        return viewModel.nameList.count()
    }
}