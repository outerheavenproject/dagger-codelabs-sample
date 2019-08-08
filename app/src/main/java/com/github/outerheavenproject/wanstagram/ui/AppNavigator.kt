package com.github.outerheavenproject.wanstagram.ui

import android.content.Context
import com.github.outerheavenproject.wanstagram.ui.detail.DetailActivity
import javax.inject.Inject

interface AppNavigator {
    fun navigateToDetail(imageUrl: String)
}

class AppNavigatorImpl @Inject constructor(
    private val context: Context
) : AppNavigator {
    override fun navigateToDetail(imageUrl: String) {
        context.startActivity(DetailActivity.createIntent(context, imageUrl))
    }
}
