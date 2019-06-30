package net.pside.android.example.petbook.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import net.pside.android.example.petbook.R
import net.pside.android.example.petbook.data.Dogs

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
        dogAdapter = DogAdapter(navigator = AppNavigatorImpl())
        recycler.layoutManager = GridLayoutManager(context, 2)
        recycler.adapter = dogAdapter

        presenter = MainPresenter(view = this)

        lifecycleScope.launch {
            presenter.start()
        }
    }

    override fun updateDogs(dogs: Dogs) {
        dogAdapter.submitList(dogs.messages)
    }
}
