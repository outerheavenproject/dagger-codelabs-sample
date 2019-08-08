package com.github.outerheavenproject.wanstagram.ui.dogaction

import javax.inject.Inject

class DogActionBottomSheetPresenter @Inject constructor(
    private val sink: DogActionSink,
    private val view: DogActionBottomSheetContract.View
) : DogActionBottomSheetContract.Presenter {
    private lateinit var url: String

    override fun start(url: String) {
        this.url = url
    }

    override fun share() {
        sink.write(url)
    }
}
