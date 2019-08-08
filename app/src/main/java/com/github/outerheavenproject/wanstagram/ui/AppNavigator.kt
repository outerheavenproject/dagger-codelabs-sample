package com.github.outerheavenproject.wanstagram.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.fragment.app.FragmentManager
import com.github.outerheavenproject.wanstagram.ui.detail.DetailActivity
import com.github.outerheavenproject.wanstagram.ui.dogaction.DogActionBottomSheetDialogFragment
import javax.inject.Inject

interface AppNavigator {
    fun navigateToDetail(imageUrl: String)
    fun navigateToAction(childFragmentManager: FragmentManager, url: String)
    fun shareUris(context: Context, uris: ArrayList<Uri>)
}

class AppNavigatorImpl @Inject constructor(
    private val context: Context
) : AppNavigator {
    override fun navigateToDetail(imageUrl: String) {
        context.startActivity(DetailActivity.createIntent(context, imageUrl))
    }

    override fun navigateToAction(childFragmentManager: FragmentManager, url: String) {
        DogActionBottomSheetDialogFragment.newInstance(url)
            .show(childFragmentManager, DogActionBottomSheetDialogFragment.TAG)
    }

    override fun shareUris(context: Context, uris: ArrayList<Uri>) {
        context.startActivity(
            Intent.createChooser(
                Intent().apply {
                    action = Intent.ACTION_SEND_MULTIPLE
                    type = "image/*"
                    putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris)
                },
                ""
            )
        )
    }
}
