package net.pside.android.example.petbook.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import net.pside.android.example.petbook.R
import net.pside.android.example.petbook.ui.dog.DogFragment
import net.pside.android.example.petbook.ui.shiba.ShibaFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(R.id.container, DogFragment())
            }
        }

        val bottom: BottomNavigationView = findViewById(R.id.bottom)
        bottom.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_dog -> {
                    supportFragmentManager.commit {
                        replace(R.id.container, DogFragment())
                    }
                }
                R.id.action_shiba -> {
                    supportFragmentManager.commit {
                        replace(R.id.container, ShibaFragment())
                    }
                }
            }
            true
        }
    }
}
