package mdmccullough.wccnet.edu.recycleviewwithintents

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val viewModel: MainViewModel) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener() {v: View ->
                val pos = adapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    val context = v.context
                    val intent = Intent(context, MainActivity2::class.java)
                    intent.putExtra("dispImage", viewModel.images[pos])
                    intent.putExtra("dispTitle", viewModel.titles[pos])
                    intent.putExtra("dispDetail", viewModel.details[pos])
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = viewModel.titles[i]
        viewHolder.itemDetail.text = viewModel.details[i]
        viewHolder.itemImage.setImageResource(viewModel.images[i])

    }
    override fun getItemCount(): Int {
        return viewModel.titles.size
    }
}