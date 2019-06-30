package net.pside.android.example.petbook.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import net.pside.android.example.petbook.R

class DetailActivity : AppCompatActivity() {
    companion object {
        private const val IMAGE_KEY = "image"

        fun createIntent(context: Context, imageUrl: String): Intent =
            Intent(context, DetailActivity::class.java).apply {
                putExtra(IMAGE_KEY, imageUrl)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val imageUrl = intent.getStringExtra(IMAGE_KEY)!!
        val image: ImageView = findViewById(R.id.image)
        Glide
            .with(image)
            .load(imageUrl)
            .into(image)
    }
}
