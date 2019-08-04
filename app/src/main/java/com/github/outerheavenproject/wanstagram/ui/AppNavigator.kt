package com.github.outerheavenproject.wanstagram.ui

import android.content.Context
import com.github.outerheavenproject.wanstagram.ui.detail.DetailActivity

interface AppNavigator {
    fun navigateToDetail(context: Context, imageUrl: String)
}

class AppNavigatorImpl : AppNavigator {
    override fun navigateToDetail(context: Context, imageUrl: String) {
        context.startActivity(DetailActivity.createIntent(context, imageUrl))
    }
}
