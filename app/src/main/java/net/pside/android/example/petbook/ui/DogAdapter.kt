package net.pside.android.example.petbook.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import net.pside.android.example.petbook.R

class DogAdapter : ListAdapter<String, DogViewHolder>(DogDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder =
        DogViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.dog_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val dogUrl = getItem(position)
        Glide.with(holder.image)
            .load(dogUrl)
            .into(holder.image)
    }
}

class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val image: ImageView = itemView.findViewById(R.id.image)
}

object DogDiffUtil : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}
