package ahmad.ir.farhngcomputershop.adapter

import ahmad.ir.farhngcomputershop.databinding.HeaderCardBinding
import ahmad.ir.farhngcomputershop.models.Header
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.header_card.view.*

class HeaderAdapter () : RecyclerView.Adapter<HeaderAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: HeaderCardBinding): RecyclerView.ViewHolder(
            binding.root
    ) {
            fun bind(header: Header) {
                binding.apply {
                }
            }
    }


    val differCallBack = object : DiffUtil.ItemCallback<Header>() {
        override fun areItemsTheSame(oldItem: Header, newItem: Header): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Header, newItem: Header): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

    }

    val differ = AsyncListDiffer(this,differCallBack)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = HeaderCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

            return ViewHolder(binding)
    }

    fun submitList(list: List<Header>) = differ.submitList(list)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = differ.currentList.get(position)
        holder.bind(image)
        holder.itemView.cover.setImageBitmap(image.image)

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}