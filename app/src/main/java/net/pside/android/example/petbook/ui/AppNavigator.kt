package net.pside.android.example.petbook.ui

import android.content.Context
import net.pside.android.example.petbook.ui.detail.DetailActivity

interface AppNavigator {
    fun navigateToDetail(context: Context, imageUrl: String)
}

class AppNavigatorImpl : AppNavigator {
    override fun navigateToDetail(context: Context, imageUrl: String) {
        context.startActivity(DetailActivity.createIntent(context, imageUrl))
    }
}
