package com.github.outerheavenproject.wanstagram.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.fragment.app.commit
import com.github.outerheavenproject.wanstagram.R
import com.github.outerheavenproject.wanstagram.ui.dog.DogFragment
import com.github.outerheavenproject.wanstagram.ui.shiba.ShibaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector, MainContract.View {
    @Inject
    lateinit var presenter: MainContract.Presenter

    @Inject
    lateinit var navigator: AppNavigator

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
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

        findViewById<View>(R.id.fab)
            .setOnClickListener { presenter.share() }

        presenter.start()
    }

    override fun shareDogs(dogs: Set<String>) {
        navigator.shareUris(this, ArrayList(dogs.map { it.toUri() }))
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
