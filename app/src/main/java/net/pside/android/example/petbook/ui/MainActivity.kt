package net.pside.android.example.petbook.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import net.pside.android.example.petbook.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(R.id.container, MainFragment())
            }
        }
    }
}
