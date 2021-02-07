package ahmad.ir.farhngcomputershop.adapter

import ahmad.ir.farhngcomputershop.databinding.LaptopCardBinding
import ahmad.ir.farhngcomputershop.models.Laptop
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.laptop_card.view.*

class LaptopAdapter(
       val context: Context
) : RecyclerView.Adapter<LaptopAdapter.ViewHolder>() {

    inner class ViewHolder(private val laptopCardBinding: LaptopCardBinding) : RecyclerView.ViewHolder (
            laptopCardBinding.root
    ) {
        fun bind(laptop: Laptop) {
            laptopCardBinding.apply {
                nameLaptop.text = laptop.mark
                priceLaptop.text = laptop.price
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LaptopCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )

        return ViewHolder(binding)
    }

    val differCallBack = object : DiffUtil.ItemCallback<Laptop>() {
        override fun areItemsTheSame(oldItem: Laptop, newItem: Laptop): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Laptop, newItem: Laptop): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }


    val differ = AsyncListDiffer(this,differCallBack);
    fun submitlist(list: List<Laptop>) = differ.submitList(list);

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val laptop = differ.currentList.get(position)
        holder.bind(laptop)
        Glide.with(context).load(laptop.img).into(holder.itemView.img_laptop);
    }

    override fun getItemCount(): Int {
        return differ.currentList.size;
    }


}