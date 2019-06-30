package net.pside.android.example.petbook.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.coroutines.launch
import net.pside.android.example.petbook.R
import net.pside.android.example.petbook.data.Dog

class MainFragment : Fragment(),
    MainContract.View {
    private lateinit var presenter: MainPresenter
    private lateinit var dogAdapter: DogAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        dogAdapter = DogAdapter()
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = dogAdapter

        presenter = MainPresenter(view = this)

        lifecycleScope.launch {
            presenter.start()
        }
    }

    override fun updateDog(dog: Dog) {
        dogAdapter.submitList(listOf(dog))
    }
}

class DogAdapter : ListAdapter<Dog, DogViewHolder>(DogDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        return DogViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.dog_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val dog = getItem(position)
        holder.title.text = dog.status
        Glide
            .with(holder.image)
            .load(dog.message)
            .into(holder.image)
    }
}

private object DogDiffUtil : DiffUtil.ItemCallback<Dog>() {
    override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
        return oldItem == newItem
    }
}

class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.title)
    val image: ImageView = itemView.findViewById(R.id.image)
}
