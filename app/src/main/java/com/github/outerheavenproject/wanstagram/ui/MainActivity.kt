package com.github.outerheavenproject.wanstagram.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.github.outerheavenproject.wanstagram.App
import com.github.outerheavenproject.wanstagram.R
import com.github.outerheavenproject.wanstagram.ui.dog.DogFragment
import com.github.outerheavenproject.wanstagram.ui.shiba.ShibaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var appNavigator: AppNavigatorImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App)
            .appComponent
            .mainActivitySubcomponentFactory()
            .create(this)
            .inject(this)

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
